package com.learning.ds.recursion;

public class StringPermutation {

    public static void main(String[] args) {
        String str = "ABC";
        int len = str.length();
        int left = 0, right = len;

        stringPermutation(str, left, right-1);
    }
    private static void stringPermutation(String str, int left, int right) {

        if(left == right){
            System.out.println(str);
        }
        else {
            for(int i=1; i<=right; i++) {
                str = swap(str, left, i);
                stringPermutation(str, left+1, right);
                str = swap(str, left, i);

            }
        }
    }

    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
