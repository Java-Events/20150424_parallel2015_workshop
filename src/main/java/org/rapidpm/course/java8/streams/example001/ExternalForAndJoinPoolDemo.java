package org.rapidpm.course.java8.streams.example001;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by sven on 22.04.15.
 */
public class ExternalForAndJoinPoolDemo {

  public static void main(String[] args) {
//    System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "30");
    System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "1");
//    doWorkExtern(ForkJoinPool.commonPool());

    IntStream.range(1, 100).forEachOrdered(i-> {
      final ForkJoinPool forkJoinPool = new ForkJoinPool(i);
      doWorkExtern(forkJoinPool);
    });

  }

  private static void doWorkExtern(ForkJoinPool forkJoinPool) {
    long start = System.nanoTime();
    Callable<List<Integer>> task = () ->
        //parallel task here, for example
        IntStream.range(1, 5_000_000)
            .parallel()
            .filter(n -> n > 1 && (n == 2 || n >= 2 && IntStream.rangeClosed(2, (int) (Math.sqrt(n))) //for(int i=3;i*i<=n;i+=2)
//            .parallel()
                .allMatch((d) -> n % d != 0)))
            .boxed()
            .collect(Collectors.toList());
    try {
      List<Integer> integers = forkJoinPool.submit(task).get();
      System.out.print("ex : integers.size() = " + integers.size());
      long stop = System.nanoTime();
      System.out.println("   ex: stop-start = " + (stop - start) / 1000 / 1000); //ms
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }
}
