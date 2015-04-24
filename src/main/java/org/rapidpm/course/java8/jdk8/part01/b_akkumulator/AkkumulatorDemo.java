package org.rapidpm.course.java8.jdk8.part01.b_akkumulator;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by Sven Ruppert on 05.03.14.
 */
public class AkkumulatorDemo {

    public static void main(String[] args) {
//        LongAdder longAdder = new LongAdder();
//        longAdder.increment();
//        longAdder.increment();
//        longAdder.decrement();
//        longAdder.add(-1);
//        longAdder.increment();
//        System.out.println("longAdder.sum() = " + longAdder.sum());

        LongAccumulator longAccumulator = new LongAccumulator((left, right) -> {
            System.out.println("left = " + left);
            System.out.println("right = " + right);

            return left + right;
        },0L);

        longAccumulator.accumulate(3);
        longAccumulator.accumulate(4);
        System.out.println("longAccumulator = " + longAccumulator.longValue());


    }
}
