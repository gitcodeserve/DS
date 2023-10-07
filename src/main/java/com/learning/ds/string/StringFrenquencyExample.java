package com.learning.ds.string;

import java.util.HashMap;
import java.util.Map;

public class StringFrenquencyExample {

    public static void main(String[] args) {
        String str = "abcddaaeeaaab";
        stringFreqencyCount(str);
    }

    private static void stringFreqencyCount(String str) {
        int strLen = str.length();
        //create array which will hold the ascii position of the character like a = 96, b = 97 etc.
        int[] charArr = new int[26];
        Map<Character, Integer> map = new HashMap<>();

        //Iterate through the string and store matching ascii value and increase that value by one for every mattching
        for(int i=0; i<strLen; i++)
            charArr[str.charAt(i)-'a']++;

        for(int i=0; i<26; i++){
            if(charArr[i] > 0){
                map.put((char) (i+'a'), charArr[i]);
            }
        }
        System.out.println(map);
    }
}
