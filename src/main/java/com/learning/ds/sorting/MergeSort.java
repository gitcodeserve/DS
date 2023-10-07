package com.learning.ds.sorting;

// Divide and Conqer technique - https://www.youtube.com/watch?v=unxAnJBy12Q&ab_channel=ApnaCollege
// Time Complexity nlog(n) - Best and worst case scenario
// Need extra memory to merge the error.
public class MergeSort {

    private static int arr[] = {6, 3, 9, 5, 2 , 8};

    public static void main(String[] args) {

        for(int i : arr) {
            System.out.print(i + " ");
        }
        divide(arr, 0, arr.length);

        System.out.println("\n");
        for(int i : arr) {
            System.out.print(i + " ");
        }

    }

    private static void divide(int[] arr, int startIndex, int endIndex) {
        if(startIndex >= endIndex) {
            return;
        }
        int midIndex = startIndex+endIndex/2;
        divide(arr, startIndex, midIndex-1);
        divide(arr, midIndex, endIndex);
        conquer(arr, startIndex, midIndex, endIndex);
    }

    private static void conquer(int arr[], int startIndex, int mid, int endIndex){
        
        int mergedArray[] = new int[endIndex - startIndex + 1];

        int inx1 = startIndex; //track first array
        int inx2 = mid+1; // track second array
        int x = 0;

        while (inx1 <= mid && inx2 <= endIndex) {
            if(arr[inx1] <= arr[inx2]) {
                mergedArray[x++] = arr[inx1++];
                //x++;
                //inx1++;
            }
            else {
                mergedArray[x++] = arr[inx2++];
                //x++;
                //inx2++;
            }
        }

        while(inx1 <= mid) {
            mergedArray[x++] = arr[inx1++];
        }
        while(inx2 <= endIndex) {
            mergedArray[x++] = arr[inx2++];
        }

        for(int i=0, j=startIndex; i<mergedArray.length; i++, j++){
            arr[i] = mergedArray[j];
        }
    }
}
