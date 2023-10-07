package com.learning.ds.array;

public class MaxSumSubArray {

    public static void main(String[] args) {
        int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        int k = 4;
        int n = arr.length;

        // by brute force
        int max_sum = max_sum_of_subarray(arr, n, k);
        System.out.println(max_sum);
    }

    // Returns maximum sum in a subarray of size k.
    public static int max_sum_of_subarray(int arr[], int n, int k)
    {
        // k must be smaller than n
        if (n < k)
        {
            System.out.println("Invalid");
            return -1;
        }

        // Compute sum of first window of size k
        int res = 0;
        for (int i=0; i<k; i++)
            res += arr[i];

        // Compute sums of remaining windows by
        // removing first element of previous
        // window and adding last element of
        // current window.
        int curr_sum = res;
        for (int i=k; i<n; i++)
        {
            curr_sum += arr[i] - arr[i-k];
            res = Math.max(res, curr_sum);
        }

        return res;
    }
}
