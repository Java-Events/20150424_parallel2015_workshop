package org.rapidpm.course.java8.streams.example001;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ForkJoinPool.html
 * Created by Sven Ruppert on 06.05.2014.
 * <p>
 * 30: seq/seq - integers.size() = 348513 - stop-start = 4803
 * 01: seq/seq - integers.size() = 348513 - stop-start = 5107
 * <p>
 * 30: par/seq - integers.size() = 348513 - stop-start = 1846
 * 01: par/seq - integers.size() = 348513 - stop-start = 3064
 * <p>
 * 30: seq/par - integers.size() = 348513 - stop-start = 123772
 * 01: seq/par - integers.size() = 348513 - stop-start = 20186
 * <p>
 * 30: par/par - integers.size() = 348513 - stop-start = 16929
 * 01: par/par - integers.size() = 348513 - stop-start = 18704
 * <p>
 * default Werte
 * def: seq/seq - integers.size() = 348513 - stop-start = 4926
 * def: seq/par - integers.size() = 348513 - stop-start = 64620
 * def: par/seq - integers.size() = 348513 - stop-start = 1826
 * def: par/par - integers.size() = 348513 - stop-start = 9619
 */
public class CommonForAndJoinPoolDemo {
  public static void main(String[] args) {
//    System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "30");
    System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "1");
    doWork();

  }


  private static void doWork() {
    long start = System.nanoTime();
    List<Integer> integers = IntStream.range(1, 5_000_000)
//        .parallel()
        .filter(n -> n > 1 && (n == 2 || n >= 2 && IntStream.rangeClosed(2, (int) (Math.sqrt(n))) //for(int i=3;i*i<=n;i+=2)
//            .parallel()
            .allMatch((d) -> n % d != 0)))
        .boxed()
        .collect(Collectors.toList());

    System.out.print("integers.size() = " + integers.size());
    long stop = System.nanoTime();
    System.out.println("   stop-start = " + (stop - start) / 1000 / 1000); //ms
  }

//  public static boolean isPrime1(int n) {
//    if (n <= 1) return false;
//    if (n == 2) return true;
//    return n >= 2 && IntStream
//        .rangeClosed(2, (int) (Math.sqrt(n)))  //for(int i=3;i*i<=n;i+=2)
////        .parallel()
//        .allMatch((d) -> n % d != 0);          //if(n%i==0) return false
//  }
}
