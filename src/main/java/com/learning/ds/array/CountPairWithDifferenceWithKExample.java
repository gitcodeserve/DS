package com.learning.ds.array;

import java.util.Arrays;

public class CountPairWithDifferenceWithKExample {

    public static void main(String[] args) {
        int [] arr = {2, 3, 5, 7, 9, 4, 5};
        int K = 5;

        System.out.println("{2, 3, 5, 7, 9, 4, 5} countPairDifferenceWith5 is " + countPairDifferenceWithK(arr, K));
    }

    private static int countPairDifferenceWithK(int[] arr, int k) {

        Arrays.sort(arr);
        int l=0, r=0;
        int n = arr.length;
        int count = 0;
        while (r < n) {
            if(arr[r]-arr[l] == k){
                System.out.println("Pair is {" + arr[l] + ", " + arr[r] + "}");
                count++;
                l++;
                r++;
            }
            else if(arr[r]-arr[l] > k){
                l++;
            }
            else
                r++;
        }

        return count;
    }
}
