package org.rapidpm.course.java8.working.java8core.v003;

/**
 * Created by sven on 24.04.15.
 */
public class Main003 {


  public static class BiFunction<A,B,C>{

  }

  public static void main(String[] args) {



  }

  public static interface DemoClassA {
      public String doWork();
  }
  public static interface DemoClassB<T> {
      public T doWork();
  }
  public static interface DemoClassC {
      public <T, A, B, C> BiFunction<A,B,C> doWork(T t);
  }


}
