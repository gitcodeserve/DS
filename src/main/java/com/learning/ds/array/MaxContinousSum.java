package com.learning.ds.array;

public class MaxContinousSum {

    public static void main(String[] args) {
        int arr[] = {2, 4, 5, 7, 1, 2, 11, 9, 5};

        int maxSum = maxContinousSumOfThree(arr, arr.length, 3);
        System.out.println("Maximum sum of arr [2, 4, 5, 7, 1, 2, 4, 2, 5] for 3 consecutive values " + maxSum);

    }

    private static int maxContinousSumOfThree(int[] arr, int arrLen, int k) {

        int sum = 0;
        int maxSum = 0;
        int start = 0, end =0;
        while (end < arrLen){
            sum = sum + arr[end];
            end++;
            if(end-start == k){
                maxSum = Math.max(maxSum, sum);
                sum = sum - arr[start];
                start++;
            }
        }
        return maxSum;

    }
}
