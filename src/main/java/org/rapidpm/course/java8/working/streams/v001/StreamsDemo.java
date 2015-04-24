package org.rapidpm.course.java8.working.streams.v001;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by sven on 24.04.15.
 */
public class StreamsDemo {

  public static void main(String[] args) {

    final List<String> stringList = new ArrayList<>();
    stringList.add("A");
    stringList.add("B");
    stringList.add("C");
    stringList.add("D");

    stringList.forEach(new Consumer<String>() {
      @Override
      public void accept(String s) {
        System.out.println(s);
      }
    });
    stringList.forEach((s) -> {
      System.out.println(s);
    });

    stringList.forEach(s -> System.out.println(s));

    stringList.forEach(System.out::println);

    final Stream<String> stream = stringList.stream();
//    stream.forEach(System.out::println);
//    stream.forEach(System.out::println);

    final Stream<String> a = Stream.of("A", "B", "C");


//    final Stream<String> streamString = Stream.generate(new Supplier<String>() {
//      int i = 0;
//
//      @Override
//      public String get() {
//        i = i + 1;
//        return String.valueOf(i);
//      }
//    });
//    streamString.forEach(System.out::println);
//    final Stream<String> streamStringConst = Stream.generate(() -> "const");

//    streamString.filter(new Predicate<String>() {
//      @Override
//      public boolean test(String s) {
//        return s.length() <= 2;
//      }
//    });

    final List<Integer> collect = Stream.generate(new Supplier<String>() {
      int i = 0;

      @Override
      public String get() {
        i = i + 1;
        return String.valueOf(i);
      }
    })
        .parallel()
        .filter(s -> s.length() <= 2)
        .limit(20)
        .sequential()
        .map(Integer::valueOf)
            //.reduce((aI, bI) -> aI + bI)
        .collect(toList());

    for (Integer i : collect) {
      System.out.println("i = " + i);
    }


  }


}
