package com.learning.ds.array;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class TopKFrequencyProblem {

    public static void main(String[] args) {
        int [] arr = {1, 1, 1, 1, 2, 3, 3, 4, 3, 3};
        int K = 2;

        //return count of top 2 element in array

        topKElement(arr, K);
    }

    private static void topKElement(int[] arr, int K) {

        Map<Integer, Integer> hashMap = new TreeMap<>();

        for(int i: arr) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }

        // Create a Priority Queue
        // to sort based on the
        // count or on the key if the
        // count is same
        PriorityQueue<Map.Entry<Integer, Integer> > queue
                = new PriorityQueue<>(
                (a, b)
                        -> a.getValue().equals(b.getValue())
                        ? Integer.compare(b.getKey(),
                        a.getKey())
                        : Integer.compare(b.getValue(),
                        a.getValue()));

        // Insert the data from the map
        // to the Priority Queue.
        for (Map.Entry<Integer, Integer> entry :
                hashMap.entrySet())
            queue.offer(entry);

        // Print the top k elements
        for (int i = 0; i < K; i++) {
            System.out.print(queue.poll().getKey() + " ");
        }


    }
}
