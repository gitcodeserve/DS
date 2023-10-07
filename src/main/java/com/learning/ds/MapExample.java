package com.learning.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> empMap = new TreeMap<>();

        empMap.put("shantanu", 44);
        empMap.put("neha", 39);
        empMap.put("aahana", 13);
        empMap.put("vedansh", 7);

        empMap.forEach((k, v) -> {
            System.out.println( k + " " + v);
        });

        System.out.println("\n----------------");
        Map<Emp, Integer> empMapNew = new TreeMap<>();
        empMapNew.put(new Emp(44, "Shantanu"), 123);
        empMapNew.put(new Emp(39, "Neha"), 124);
        empMapNew.put(new Emp(13, "Aahana"), 125);
        empMapNew.put(new Emp(7, "Vedansh"), 126);

        empMapNew.forEach((k, v) ->
                System.out.println(k.getName() + " --- " + k.getAge()));

        Map<String, Integer> budget = new HashMap<>();
        budget.put("clothes", 120);
        budget.put("grocery", 150);
        budget.put("transportation", 100);
        budget.put("utility", 130);
        budget.put("rent", 1150);
        budget.put("miscellneous", 90);

        System.out.println("map before sorting: " + budget);

        // let's sort this map by values first
        Map<String, Integer> sorted = budget
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(
                        Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
                                LinkedHashMap::new));

        System.out.println("map after sorting by values: " + sorted);


    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    static class Emp implements Comparable <Emp>{
        private int age;
        private String name;


        @Override
        public int compareTo(Emp emp) {
            return Integer.compare(this.getAge(), emp.getAge());
        }
    }
}
