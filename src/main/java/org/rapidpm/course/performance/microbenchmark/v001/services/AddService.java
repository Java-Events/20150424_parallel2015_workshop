package org.rapidpm.course.performance.microbenchmark.v001.services;

/**
 * Created by sven on 19.01.15.
 */
public class AddService {

    public AddService() {System.out.println("constructor = " + this.getClass().getSimpleName());
    }

    public int add(int a, int b){
        return a +b;
    }
}
