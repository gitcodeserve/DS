package com.learning.ds.design.list;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class ListOperation {

    public static void main(String[] args) {
        //Remove Duplicate element from the list
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 1, 2);
        list.forEach(System.out::print);
        System.out.println("\n");
        Set<Integer> set = new TreeSet<>(list);
        set.forEach(System.out::print);
    }
}
