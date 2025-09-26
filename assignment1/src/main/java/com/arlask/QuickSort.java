package com.arlask;



import com.arlask.metrics.Metrics;
import com.arlask.metrics.Util;


public class QuickSort {
        
    public static void quicksort(int[] arr,int l, int h,Metrics metrics){
        
         while(l<h){
            int p = Util.partition(arr, l, h);

            if(p-l<h-p){
                quicksort(arr, l, p-1,metrics);
                l=p+1;
            }
            else{
                quicksort(arr, p+1, h,metrics);
                h=p-1;
            }
        }
    }

}