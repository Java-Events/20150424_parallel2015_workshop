package org.rapidpm.course.java8.working.java8core.v004;

import org.rapidpm.course.java8.working.java8core.v002.Main002;

/**
 * Created by sven on 24.04.15.
 */
public class Main004 {


  public static void main(String[] args) {

    class DemoC extends DemoClass{
      public void doWork() {
        System.out.println("DemoC = ");
      }
    }
    final DemoClass demoC = new DemoC();

    demoC.doWork();

  }




  public static class DemoClass{

    public void doWork(){
      System.out.println("DemoClass = ");
    }
  }
}
