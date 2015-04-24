package org.rapidpm.course.java8.jdk8.part01.d_completabelfuture.uebung;

import java.util.Date;

/**
 * Created by Sven Ruppert on 07.05.2014.
 */
public class Main {

  public static void main(String[] args) {
    final SimpleDateformatExample versionAB = new SimpleDateformatExample();

    versionAB.createSDF();
//        TimeUnit.SECONDS.sleep(4);
    versionAB.newPattern("yyyy.MM.dd");
//        TimeUnit.SECONDS.sleep(4);

    final String s = versionAB.format(new Date());
    System.out.println("s = " + s);

//        final SimpleDateformatExample versionAB = new SimpleDateformatExample();
//        versionAB.newPattern("yyyy.MM.dd");
//        versionAB.createSDF();
//        final String s = versionAB.format(new Date());
//        System.out.println("s = " + s);
  }
}
