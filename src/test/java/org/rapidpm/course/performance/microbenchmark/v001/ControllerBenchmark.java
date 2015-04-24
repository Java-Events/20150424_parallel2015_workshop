package org.rapidpm.course.performance.microbenchmark.v001;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by sven on 20.01.15.
 */
@BenchmarkMode(Mode.All)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(value = 1, warmups = 2)
@Measurement(iterations = 3, time = 5, timeUnit = TimeUnit.SECONDS)
@Threads(value = 2)
@State(Scope.Thread)
public class ControllerBenchmark {
    @Benchmark
    public void benchmarkRuntimeOverhead() {
    }

    String result;

    @Benchmark
    public void insertBench(BenchmarkState benchmarkState,
                            BenchmarkStateThread benchmarkStateThread) {
        Controller controller = benchmarkStateThread.controller;
        result = controller.add("1", "2");
    }

    @State(Scope.Benchmark) // einmal pro Testdurchlauf
    public static class BenchmarkState {
//        @Param({"1", "31"})
//        public int p1;
//
//        @Param({"0", "1", "2"})
//        public int p2;

        public BenchmarkState() {
            System.out.println("constructor " + BenchmarkState.class.getSimpleName());
        }

        @Setup
        public void setUp() throws Exception {
            System.out.println("BenchmarkState-setUp = " + System.nanoTime());
        }

        @TearDown
        public void tearDown() {
            System.out.println("BenchmarkState-tearDown = " + System.nanoTime());
        }

    }

    @State(Scope.Thread)//einmal pro thread im TestDruchlauf
    public static class BenchmarkStateThread {

        public Controller controller = new Controller();

        public BenchmarkStateThread() {
            System.out.println("constructor " + BenchmarkStateThread.class.getSimpleName());
        }

        @Setup
        public void setUp() throws Exception {
            System.out.println("BenchmarkStateThread-setUp = " + System.nanoTime());
        }

        @TearDown
        public void tearDown() {
            System.out.println("BenchmarkStateThread-tearDown = " + System.nanoTime());
        }
    }

}
