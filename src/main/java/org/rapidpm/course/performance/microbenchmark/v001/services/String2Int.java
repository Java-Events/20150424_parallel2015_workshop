package org.rapidpm.course.performance.microbenchmark.v001.services;

/**
 * Created by sven on 19.01.15.
 */
public class String2Int {
    public String2Int() {System.out.println("constructor = " + this.getClass().getSimpleName());
    }

    public int convert(String s){
        return Integer.valueOf(s);
    }
}
