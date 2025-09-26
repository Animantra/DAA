package com.arlask.metrics;

import java.util.Random;

public class Util{

    public static boolean guardArr(int[] arr, int l, int r){
        return arr != null && arr.length > 0 && l < r;
    }

    public static void insertionSort(int [] arr,int l, int r,Metrics metrics){
        if(!guardArr(arr, l, r)) {
            return;
        }
        for(int i=l+1;i<=r;++i){
            int key = arr[i];
            int j=i-1;
            while(j>=l){
                metrics.incComparisons();
                if(arr[j]>key){
                    arr[j+1]=arr[j];
                    metrics.incSwaps();
                    j--;
                }else{
                    break;
                }
               
            }
        arr[j+1]=key;
        metrics.incSwaps();
        }
    }


     public static int partition(int arr[] ,int low,int high){
         if(!guardArr(arr, low, high)) {
            return low;
        }

        Random random=new Random();

        int pivotIndex = low+random.nextInt(high-low+1);  
        int pivot=arr[pivotIndex];

        int temp=arr[pivotIndex];
        arr[pivotIndex]=arr[high];
        arr[high]=temp;

        int i = low-1;
        for (int j=low; j<high; j++)
        {
          
            if (arr[j] <= pivot)
            {
                i++;

                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }
}