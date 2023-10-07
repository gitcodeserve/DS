package com.learning.ds.sorting;


// https://www.youtube.com/watch?v=QXum8HQd_l4&ab_channel=ApnaCollege
// Time Complexity nlog(n) - Best case scenario, o(n^2) - Worse case scenario - if pivot is smallest / largest in case of array completely sorted
// Need extra memory to merge the error.
public class QuickSort {

    public static void main(String[] args) {
        int [] arr = {6, 5, 8, 2, 4, 7};
        int arrLen = arr.length;

        for(int i : arr) {
            System.out.print( i + " ");
        }

        System.out.println("\n----------");

        quickSort(arr, 0, arrLen-1);

        for(int i : arr) {
            System.out.print( i + " ");
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pivotIndex = paritition(arr, low, high);
            quickSort(arr, low, pivotIndex-1);
            quickSort(arr, pivotIndex, high);

        }
    }

    private static int paritition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low-1;

        for(int j=low; j<high; j++){
            if(arr[j] < pivot) {
                i++;
                // swapping
                int tmp = arr[j];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        // Making space of pivot
        i++;
        int tmp = arr[i];
        arr[i] = pivot;
        arr[high] = tmp;
        return i;
    }
}
