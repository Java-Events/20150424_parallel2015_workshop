package org.rapidpm.course.java8.working.java8core.v002;

/**
 * Created by sven on 24.04.15.
 */
public class Main002 {


  public static void main(String[] args) {
    new DemoClass() {
      @Override
      public void doWork() {

      }
    }.doWork();

    final DemoClass demoClass = () -> {
      System.out.println("args = ");
    };

    final DemoClass demoClassA = () -> System.out.println("args = ");

    //System.out::println


//    final DemoClassA demoClassA = () -> {return null;};

    demoClass.doWork();




  }

@FunctionalInterface
  public static interface DemoClass {
    //    static {}
    //    {}
    public static final String huhu = "";
    public static void doStaticStuff(){}
    public void doWork();
    public String toString();
//    protected Object clone()throws CloneNotSupportedException;
  }
//  @FunctionalInterface
  public static interface DemoClassA extends DemoClass {
    public default void doWork() {
      System.out.println("DemoClassA = ");
    }
  }
  public static interface DemoClassB extends DemoClass {
    public default void doWork() {
      System.out.println("DemoClassB = ");
    }
  }
  public static interface DemoClassB1 extends DemoClassB {
    public default void doWork() {
      System.out.println("DemoClassB1 = ");
    }
  }

//  public static class DemoA implements DemoClassA, DemoClassB{
//
//  }
//
//  public static class DemoC implements DemoClassA, DemoClassB1{
//
//  }
  public static class DemoD implements DemoClassB1{

  }



  public static class DemoB implements DemoClassA, DemoClassB{
    @Override
    public void doWork() {

    }
  }

}
