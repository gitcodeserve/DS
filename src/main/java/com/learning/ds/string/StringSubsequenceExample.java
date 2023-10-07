package com.learning.ds.string;

public class StringSubsequenceExample {
    public static void main(String[] args) {
        String str1 = "abcefghi";
        String str2 = "acfg";

        boolean isValidSubseq = isSubsequence(str1, str2);
        if(isValidSubseq)
            System.out.println(str2 + " is valid subsequence of " + str1);
        else
            System.out.println(str2 + " is invalid subsequence of " + str1);
    }

    private static boolean isSubsequence(String str1, String str2) {

        int m = str1.length();
        int n = str2.length();
        int j=0;
        for(int i=0; i<m && j<n; i++){
            if(str1.charAt(i) == str2.charAt(j)){
                j++;
            }
        }
        return (j==m);
    }


}
