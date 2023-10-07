package com.learning.ds.array;

import java.util.HashMap;
import java.util.Map;

// 1010. Pairs of Songs With Total Durations Divisible by 60
public class PairofSongDivisbleBy60Example {

    public static void main(String[] args) {

        int[] time = {30,20,150,100,40};

        Map<Integer, Integer> map = new HashMap<>();

        int count=0;

        for (int i = 0; i < time.length; i++) {

            int key = time[i] % 60;
            int pairedKey = key == 0 ? key : 60 - key;

            count += map.getOrDefault(pairedKey, 0);

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        System.out.println("Pairs of songs divisble by 60 " + count);



    }
}
