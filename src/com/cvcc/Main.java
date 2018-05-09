package com.cvcc;
//This program needs to be able to search an array of no less than 20 integers for 5 values
// utilizing both binary and sequential search methods.  It should then analyze the number of
// comparisons made by each method and output the results with the data collected.

import java.util.Random; //Needed for random numbers

public class Main {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}; //An array of 20+1
        int[] results;  //An array to store binary search results
        int binCompares;  //Binary comparisons per run
        int seqCompares;  //Sequential comparisons per run
        int totBinCompares = 0;  //Binary comparisons in all
        int totSeqCompares = 0;  //Sequential comparisons in all

        for (int i = 0; i < 5; i++){   //Specs say locate at least 5 values
            int searchKey = (new Random().nextInt(20)+1); //Set a random search value

            //Format output
            System.out.println("On run "+(i+1)+":");
            System.out.println("The Key "+searchKey+" found at index: "+sequentialSearch(arr1, searchKey));
            seqCompares = sequentialSearch(arr1, searchKey)+1;
            results = binarySearch(arr1, searchKey);
            binCompares = results[1];
            System.out.println("Binary search made "+binCompares+" comparisons.");
            System.out.println("Sequential search made "+seqCompares+" comparisons.");
            totBinCompares = totBinCompares + binCompares;
            totSeqCompares = totSeqCompares + seqCompares;
            System.out.println("So far the Binary method has made "+totBinCompares+" comparisons.");
            System.out.println("So far the Sequential method has made "+totSeqCompares+" comparisons.");
        }

    }

    //The sequential search method
    public static int sequentialSearch(int[] arr, int key){

        int size = arr.length;
        for(int i=0;i<size;i++){
            if(arr[i] == key){
                return i;
            }
        }
        return -1;  //If not found return -1
    }

    //The binary search method
    public static int[] binarySearch(int[] arr, int searchKey) {

        int start = 0;
        int compare = 0;
        int[] results = {0,0};
        int end = arr.length - 1;
        while (start <= end) {
            compare++;
            int mid = (start + end) / 2;
            if (searchKey == arr[mid]) {
                results[0] = mid;
                results[1] = compare;
                return results;
            }
            if (searchKey < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        results[0] = -1;
        results[1] = -1;
        return results;  //If not found return -1
    }


}

