package com.epam.mjc;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return new Predicate<List<String>>() {
            @Override
            public boolean test(List<String> strings) {
                boolean result = true;
                for (String s : strings) {
                    if (s.charAt(0) < 65 || s.charAt(0) > 90) {
                        result = false;
                        break;
                    }
                }
                return result;
            }
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> integers) {
                integers.addAll(integers.stream()
                        .filter(i -> i % 2 == 0)
                        .collect(Collectors.toList()));
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return new Supplier<List<String>>() {
            @Override
            public List<String> get() {
                return values.stream().filter(s -> s.charAt(0) > 64 && s.charAt(0) < 91)
                        .filter(s -> s.endsWith("."))
                        .filter(s -> s.split(" ").length > 3)
                        .collect(Collectors.toList());
            }
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return new Function<List<String>, Map<String, Integer>>() {
            @Override
            public Map<String, Integer> apply(List<String> strings) {
                return strings.stream()
                        .collect(Collectors.toMap(String::toString, String::length));
            }
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return new BiFunction<List<Integer>, List<Integer>, List<Integer>>() {
            @Override
            public List<Integer> apply(List<Integer> integers, List<Integer> integers2) {
                return Stream.concat(integers.stream(), integers2.stream())
                        .collect(Collectors.toList());
            }
        };
    }
}
