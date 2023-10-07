package com.learning.ds.string;

import java.util.Arrays;

public class AnagramExample {

    public static void main(String[] args) {
        String str1 = "shantanu";
        String str2 = "anTHnauS";

        char[] str1Char = str1.toLowerCase().toCharArray();
        char[] str2Char = str2.toLowerCase().toCharArray();


        Arrays.sort(str1Char);
        Arrays.sort(str2Char);

        boolean isAnagram = false;
        if(str1.length() == str2.length()){
            for(int i=0; i<str1.length(); i++){
                if (str1Char[i] != str2Char[i]){
                    isAnagram = false;
                    System.out.println("Not a anagram string");
                    break;
                }
                else {
                    isAnagram = true;
                }
            }
        }

        else {
            System.out.println("Not anagram string");;
        }

        if(isAnagram) {
            System.out.println(str1 + " is anagram of " + str2);
        }
        else{
            System.out.println(str1 + " is not an anagram of " + str2);
        }



    }
}
