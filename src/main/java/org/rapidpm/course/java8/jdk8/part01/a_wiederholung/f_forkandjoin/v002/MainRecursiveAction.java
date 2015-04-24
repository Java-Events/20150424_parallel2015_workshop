package org.rapidpm.course.java8.jdk8.part01.a_wiederholung.f_forkandjoin.v002;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * Created by sven on 22.04.15.
 */
public class MainRecursiveAction {

  public static void main(String[] args) {
    final ForkJoinPool forkJoinPool = new ForkJoinPool(4);
    MyRecursiveAction myRecursiveAction = new MyRecursiveAction(240);
    forkJoinPool.invoke(myRecursiveAction);
    try {
      forkJoinPool.awaitTermination(10, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


  public static class MyRecursiveAction extends RecursiveAction {
    private long workLoad = 0;

    public MyRecursiveAction(long workLoad) {
      this.workLoad = workLoad;
    }

    @Override
    protected void compute() {
      //if work is above threshold, break tasks up into smaller tasks
      if (this.workLoad > 16) {
        System.out.println("Splitting workLoad : " + this.workLoad);
        List<MyRecursiveAction> subtasks = new ArrayList<>();
        subtasks.addAll(createSubtasks());
        for (final RecursiveAction subtask : subtasks) {
          subtask.fork();
        }
      } else {
        System.out.println("Doing workLoad myself: " + this.workLoad);
      }
    }

    private List<MyRecursiveAction> createSubtasks() {
      List<MyRecursiveAction> subtasks = new ArrayList<>();
      MyRecursiveAction subtask1 = new MyRecursiveAction(this.workLoad / 2);
      MyRecursiveAction subtask2 = new MyRecursiveAction(this.workLoad / 2);
      subtasks.add(subtask1);
      subtasks.add(subtask2);
      return subtasks;
    }

  }
}
