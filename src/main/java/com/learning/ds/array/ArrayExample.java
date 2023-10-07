package com.learning.ds.array;

public class ArrayExample {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3 ,4, 5, 6};
        int [] arrNew = new int[7];

        for(int i=0; i<arr.length; i++){
            arrNew[i] = arr[i];
        }
        arrNew[6] = 90;

        for(int i: arrNew) {
            System.out.print( i + " ");
        }

    }
}
