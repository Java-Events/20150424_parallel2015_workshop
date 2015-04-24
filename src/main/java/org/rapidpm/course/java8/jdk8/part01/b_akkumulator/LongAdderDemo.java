package org.rapidpm.course.java8.jdk8.part01.b_akkumulator;

import java.util.concurrent.atomic.LongAdder;

/**
 * Created by sven on 22.04.15.
 */
public class LongAdderDemo {

  public static void main(String[] args) {
    LongAdder longAdder = new LongAdder();
    longAdder.add(5);
    longAdder.add(-5);
    longAdder.increment();
    longAdder.decrement();
    longAdder.increment();
    System.out.println("longAdder.intValue() = " + longAdder.intValue());
    final long sum = longAdder.sum();
    System.out.println("sum = " + sum);
    System.out.println("longAdder.intValue() = " + longAdder.intValue());

    final long sumThenReset = longAdder.sumThenReset();
    System.out.println("sumThenReset = " + sumThenReset);
    System.out.println("longAdder.intValue() = " + longAdder.intValue());

  }
}
