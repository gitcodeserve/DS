package com.learning.ds.array;

// https://leetcode.com/problems/trapping-rain-water/
// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

//Example 1:
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
public class TappingWaterProblem {

    public static int trap(int[] height) {

        int size = height.length;
        int left[] = new int[size];
        int right[] = new int[size];

        left[0] = height[0];

        //iterate from the beginning and get get the max at each index

        for(int i=1; i<size; i++){
            left[i] = Math.max(left[i-1], height[i]);
        }

        right[size-1] = height[size-1];

        // iterate from the end and get the max at each index

        for(int i=size-2; i>=0; i--) {
            right[i] = Math.max(right[i+1], height[i]);
        }

        int totalRain = 0;
        for(int i=0; i<size; i++) {
            totalRain += (Math.min(left[i], right[i])-height[i]);
        }
        return totalRain;

    }

    public static void main(String[] args) {
        int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        int unitOfWater = trap(arr);
        System.out.println("Trapping water " + unitOfWater);
     }
}
