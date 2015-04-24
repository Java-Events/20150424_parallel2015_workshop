package org.rapidpm.course.java8.jdk8.part01.a_wiederholung.f_forkandjoin.v001;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * Created by sven on 22.04.15.
 */
public class MonitoringForAndJoinPool {

  public static void main(String[] args) {
    final ForkJoinPool pool = new ForkJoinPool();
    int array[] = new int[100_000];
    Task task1 = new Task(array, 0, array.length);
    pool.execute(task1);
    try {
      while (!task1.isDone()) {
        showLog(pool);
        TimeUnit.SECONDS.sleep(1);
      }
      pool.shutdown();
      pool.awaitTermination(1, TimeUnit.DAYS);
      showLog(pool);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private static void showLog(ForkJoinPool pool) {
    System.out.printf("**********************\n");
    System.out.printf("Main: Fork/Join Pool log\n");
    System.out.printf("Main: Fork/Join Pool: Parallelism: %d\n", pool.getParallelism());
    System.out.printf("Main: Fork/Join Pool: Pool Size: %d\n", pool.getPoolSize());
    System.out.printf("Main: Fork/Join Pool: Active Thread Count: %d\n", pool.getActiveThreadCount());
    System.out.printf("Main: Fork/Join Pool: Running Thread Count: %d\n", pool.getRunningThreadCount());
    System.out.printf("Main: Fork/Join Pool: Queued Submission: %d\n", pool.getQueuedSubmissionCount());
    System.out.printf("Main: Fork/Join Pool: Queued Tasks: %d\n", pool.getQueuedTaskCount());
    System.out.printf("Main: Fork/Join Pool: Queued Submissions: %s\n", pool.hasQueuedSubmissions());
    System.out.printf("Main: Fork/Join Pool: Steal Count: %d\n", pool.getStealCount());
    System.out.printf("Main: Fork/Join Pool: Terminated : %s\n", pool.isTerminated());
    System.out.printf("**********************\n");
  }


  public static class Task extends RecursiveAction {

    private int array[];
    private int start;
    private int stop;

    public Task(int array[], int start, int stop) {
      this.array = array;
      this.start = start;
      this.stop = stop;
    }

    @Override
    protected void compute() {
      if (stop - start > 100) {
        int mid = (start + stop) / 2;
        Task t1 = new Task(array, start, mid);
        Task t2 = new Task(array, mid, stop);
        t1.fork();
        t2.fork();
        t1.join();
        t2.join();
      } else {
        for (int i = start; i < stop; i++) {
          array[i]++;
          try {
            Thread.sleep(5);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }


}
