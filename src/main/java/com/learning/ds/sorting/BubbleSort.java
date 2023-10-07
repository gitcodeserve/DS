package com.learning.ds.sorting;

public class BubbleSort {

    public static void main(String[] args) {

        int [] arr = {8, 9, 4, 3, 2, 10, 5};

        for(int i: arr) {
            System.out.print(i + " ");
        }

        // Arrays.sort(arr);
        int arrNew [] = new int[7];
        for (int i=0; i< arr.length; i++){
            for (int j=i+1; j< arr.length; j++) {
                if (arr[i] > arr[j]) {
                    //swap
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        System.out.println("\n");
        for(int i: arr) {
            System.out.print(i + " ");
        }
    }
}
