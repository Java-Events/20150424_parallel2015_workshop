package org.rapidpm.course.java8.working.java8core.v001;

/**
 * Created by sven on 24.04.15.
 */
public class Main001 {

  public static void main(String[] args) {

    final DemoAction demoAction01 = new DemoAction() {
      {

      }
      @Override
      public void doWork() {

      }
    };
    final DemoAction demoAction02 = () -> {

    };


    System.out.println("InnerStaticClass = " + new InnerStaticClass());
    System.out.println("InnerStaticClass = " + new InnerStaticClass());
    System.out.println("InnerStaticClass = " + new InnerStaticClass());

    final InnerStaticClass innerStaticClass = new InnerStaticClass();
    final Main001 main001 = new Main001();
    final InnerNonStaticClass innerNonStaticClass = main001.new InnerNonStaticClass();

  }


  public static class InnerStaticClass {

    static {
      System.out.println("static 01= ");
    }
    static {
      System.out.println("static 02= ");
    }

    {
      System.out.println("non-static 01= ");
    }
    {
      System.out.println("non-static 02= ");
    }

    public InnerStaticClass() {
      System.out.println("constructor = ");
    }

    {
      System.out.println("non-static 03= ");
    }


  }

  public class InnerNonStaticClass {
  }


  public static interface DemoAction {
    public void doWork();
  }

}
