package com.learning.ds.array;

public class TwoDArray {

    public static void main(String[] args) {

        int [][] arr = new int[3][3];

        arr[0] = new int[]{1, 2, 3};
        arr[1] = new int[]{4, 5, 6};
        arr[2] = new int[]{7, 8, 9};

        for(int[] tmpArr: arr) {
            for (int i: tmpArr){
                System.out.print(i + " ");
            }
        }

        System.out.println("First row third col " + arr[0][2]);
        System.out.println("Second row third col " + arr[1][2]);


    }
}
