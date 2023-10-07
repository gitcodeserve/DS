package com.learning.ds.math;

public class BinaryToDecimal {

    public static void main(String[] args) {
        int decimal = convertToDecimal("1001");
        System.out.println("Decimal value of 1001 " + decimal );
    }

    private static int convertToDecimal(String s) {
        int num = Integer.parseInt(s);
        int power=0;
        int decimal=0;
        while (num != 0) {
            int lastDigiht = num % 10;
            decimal += lastDigiht * Math.pow(2, power);
            power++;
            num = num / 10;
        }
        return decimal;
    }
}
