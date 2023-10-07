package com.learning.ds.recursion;

public class FactorialExample {

    public static void main(String[] args) {
        int factorial = factorial(5);
        System.out.println("Factorial of 5 is " + factorial);
    }

    private static int factorial(int i) {
        if(i == 1)
            return i;
        int fact = i * factorial(i-1);
        return fact;
    }
}
