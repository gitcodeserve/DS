package com.learning.ds.array;

// https://www.youtube.com/watch?v=TfQPoaRDeMQ&list=RDCMUC5WO7o71wvxMxEtLRkPhiQQ&index=3&ab_channel=AdityaVerma

//Variable size window - https://www.youtube.com/watch?v=LV-BgyeH8yo&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=9&ab_channel=AdityaVerma


public class LargestSubArrayOfSum {
    
    public static void main(String ... arg) {
        int arr[] = {1, 1, 4, 6, 2, 4, 2, 2, 2, 2};
        int k = 0;
        int sum = 8;
        System.out.println("Max lenth array " + lenOfLongSubarr(arr, arr.length, sum));
    }

    static int lenOfLongSubarr(int A[], int N, int K)
    {

        int i = 0, j = 0, sum = 0;
        int maxLen = Integer.MIN_VALUE;

        while (j < N) {
            sum += A[j];
            if (sum < K) {
                j++;
            }
            else if (sum == K) {
                maxLen = Math.max(maxLen, j-i+1);
                j++;
            }
            else if (sum > K) {
                while (sum > K) {
                    sum -= A[i];
                    i++;
                }
                if(sum == K){
                    maxLen = Math.max(maxLen, j-i+1);
                }
                j++;
            }
        }
        return maxLen;
    }
}
