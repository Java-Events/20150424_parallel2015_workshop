package org.rapidpm.course.java8.jdk8.part01.d_completabelfuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

/**
 * Created by ts40 on 05.03.14.
 */
public class CompletionStageDemo {


    public static void main(String[] args) {
        final ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);

        Supplier<String> task = ()-> "42";

        try {
            final Void aVoid = CompletableFuture.supplyAsync(task, fixedThreadPool)
                    .thenAccept(System.out::println)
                    .get(); //falls Rueckgabewert notwendig
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        try {
          Integer result = CompletableFuture.supplyAsync(task, fixedThreadPool)
              .thenApplyAsync(Integer::parseInt)
              .get();
          Void resultVoid = CompletableFuture.supplyAsync(task, fixedThreadPool)
              .thenApplyAsync(Integer::parseInt)
              .thenAccept(System.out::println)
              .join();


//          fex.thenAccept(System.out::println);
//          System.out.println("f0.get() = " + f0.get());
//          System.out.println("fex.get() = " + fex.get());
//          fex.thenAccept(System.out::println);
//          fex.join();
//
//          CompletableFuture<Integer> fhandle = f0.handleAsync((v, ex) -> {
//            if (v != null) {
//              return Integer.parseInt(v);
//            } else {
//              System.out.println("v = " + v);
//              return -1;
//            }
//          });
//          fex = f0.exceptionally(ex -> " Mist " + ex.getMessage());
//          System.out.println("fhandle = " + fhandle);
//          System.out.println("fhandle.isCompletedExceptionally() = " + fhandle.isCompletedExceptionally());
//          System.out.println("fex = " + fex);
//          System.out.println("fex.get() = " + fex.get());
//          fex.thenAccept(System.out::println);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
