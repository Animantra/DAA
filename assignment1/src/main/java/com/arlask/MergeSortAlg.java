package com.arlask;

import com.arlask.metrics.Metrics;
import com.arlask.metrics.Util;

public class MergeSortAlg {

    public static void mergesort(int[] arr,int buffer[],int l, int r,Metrics metrics){
        int cutoff=16;

        if (r - l <= cutoff) {
            Util.insertionSort(arr, l, r, metrics); 
            return;
        }

        metrics.enterRec();
        int m = (l+r)/2; 
        mergesort(arr,buffer,l,m,metrics);
        mergesort(arr,buffer,m+1,r,metrics);
        merge(arr,buffer ,l, m, r,metrics);
        metrics.leaveRec();
    
}

    public static void merge(int[] arr,int buffer[],int l, int m, int r,Metrics metrics){
        int i=l;
        int j=m+1;
        int k=l;


        while(i<=m &&j<=r ){
            metrics.incComparisons();
            if(arr[i]<=arr[j]){
                buffer[k++]=arr[i++];
                metrics.incSwaps();
            }else{
                buffer[k++]=arr[j++];
                metrics.incSwaps();
            }
        }

            while(i<=m){
                buffer[k++]=arr[i++];
                metrics.incSwaps();
            }
            while (j<=r) {
                buffer[k++]=arr[j++];
                 metrics.incSwaps();

            }

            for(i=l;i<=r;i++){
                arr[i]=buffer[i];
                metrics.incSwaps();
            }

        }
    }

