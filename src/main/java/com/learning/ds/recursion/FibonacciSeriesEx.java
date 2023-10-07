package com.learning.ds.recursion;

public class FibonacciSeriesEx {

    public static void main(String[] args) {
        // Given Number N
        int N = 10;

        // Print the first N numbers
        for (int i = 0; i < N; i++) {

            System.out.print(fib(i) + " ");
        }
    }

    private static int fib(int number) {

        if(number == 0) {
            return 0;
        }

        if(number == 1){
            return 1;
        }

        int result = fib(number - 1) + fib(number - 2);
        return result;
    }
}
