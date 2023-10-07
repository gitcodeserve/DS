package com.learning.ds.array;

import java.util.ArrayList;

public class IndexOnTargetExample {
    public static void main(String[] args) {

        int arr[] = {1, 2, 15, 3, 9, 9, 5, 7};
        int len = arr.length;
        int target = 9;

        ArrayList<Integer> lstIndex = findIndexByTarget(arr, len, target);
        for(Integer intIndex: lstIndex)
            System.out.println(intIndex);
    }
    public static ArrayList findIndexByTarget(int arr[], int len, int target){
        ArrayList<Integer> lstIndex = new ArrayList();

        int i=0;
        int j=1;
        int sum=0;

        while(j < len){

            if(arr[i] + arr[j] == target){
                lstIndex.add(i);
                lstIndex.add(j);
                return lstIndex;
            }

            else if(arr[i] > target){
                i++;
                j++;
                continue;
            }

            else if(arr[i] + arr[j] > target){
                j++;
            }
            else if(j+1 == len){
                i++;
                j = i+1;
            }
            else {
                j++;
                continue;
            }
        }
        return new ArrayList<>();
    }

}
