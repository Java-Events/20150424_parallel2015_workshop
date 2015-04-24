package org.rapidpm.course.java8.jdk8.part01.c_stampedlock;

import java.util.concurrent.locks.StampedLock;

/**
 * Created by Sven Ruppert on 12.11.13.
 */
public class MyPoint {

  private double x, y;
  private final StampedLock sl = new StampedLock();

  // method is modifying x and y, needs exclusive lock
  public void move(double deltaX, double deltaY) {
    long stamp = sl.writeLock();
    try {
      x += deltaX;
      y += deltaY;
    } finally {
      sl.unlockWrite(stamp);
    }
  }

  //…
  public double distanceFromOrigin() {
    long stamp = sl.tryOptimisticRead();
    double currentX = x, currentY = y;
    if (!sl.validate(stamp)) {
      stamp = sl.readLock();
      try {
        currentX = x;
        currentY = y;
      } finally {
        sl.unlockRead(stamp);
      }
    }
    return Math.hypot(currentX, currentY);
  }


  public boolean moveIfAt(double oldX, double oldY,
                          double newX, double newY) {
    long stamp = sl.readLock();
    try {
      while (x == oldX && y == oldY) {
        long writeStamp = sl.tryConvertToWriteLock(stamp);
        if (writeStamp != 0L) {
          stamp = writeStamp;
          x = newX;
          y = newY;
          return true;
        } else {
          sl.unlockRead(stamp);
          stamp = sl.writeLock();
        }
      }
      return false;
    } finally {
      sl.unlock(stamp);
    }
  }

}
