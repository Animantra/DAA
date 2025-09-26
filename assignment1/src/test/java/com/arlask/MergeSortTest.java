package com.arlask;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.arlask.metrics.Metrics;

import java.util.Arrays;
import java.util.Random;

public class MergeSortTest {
    Metrics metrics=new Metrics();


    @Test
    void MergeTestRandom(){
        int [] arr=new int[100];

        int[] buffer=new int[arr.length];
        Random random=new Random();
        for(int i=0;i<arr.length;i++){
            arr[i]=random.nextInt(100) * (random.nextBoolean() ? 1 :-1);
        }

        int [] copy=arr.clone();

        MergeSortAlg.mergesort(arr,buffer,0,arr.length-1,metrics);

        System.out.println(Arrays.toString(arr));

        Arrays.sort(copy);
        assertArrayEquals(copy,arr);
    }

    @Test
    void AdverTest(){
        int arr[]={-2,-1,0,3,4,5,9};

        int[] buffer=new int[arr.length];

        int []copy=arr.clone();
         MergeSortAlg.mergesort(arr,buffer,0,arr.length-1,metrics);

        System.out.println(Arrays.toString(arr));

        Arrays.sort(copy);
        assertArrayEquals(copy,arr);
    }

    @Test
    void NegativeTest(){
        int arr[]={-1,-99,-2,-3,-6,-4,-9};
        int[] buffer=new int[arr.length];
        int []copy=arr.clone();
        MergeSortAlg.mergesort(arr,buffer,0,arr.length-1,metrics);

        System.out.println(Arrays.toString(arr));

        Arrays.sort(copy);
        assertArrayEquals(copy,arr);

    }
    
}



