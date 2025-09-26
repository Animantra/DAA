package com.arlask;


import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.arlask.metrics.Metrics;

public class QuicksortTests {
    Metrics metrics=new Metrics();


    @Test
    void quicksorttestRandom(){
        int [] arr=new int[100];
        Random random=new Random();
        for(int i=0;i<arr.length;i++){
            arr[i]=random.nextInt(100)* (random.nextBoolean() ? 1 :-1);;
        }

        int [] copy=arr.clone();

        QuickSort.quicksort(arr,0,arr.length-1,metrics);

        System.out.println(Arrays.toString(arr));

        Arrays.sort(copy);
        assertArrayEquals(copy,arr);
    }

    @Test
    void adverTest(){
        int arr[]={-2,-1,0,3,4,5,9};
        int []copy=arr.clone();
         QuickSort.quicksort(arr,0,arr.length-1,metrics);

        System.out.println(Arrays.toString(arr));

        Arrays.sort(copy);
        assertArrayEquals(copy,arr);
    }

    @Test
    void negativeTest(){
        int arr[]={-1,-99,-2,-3,-6,-4,-9};
        int []copy=arr.clone();
        QuickSort.quicksort(arr,0,arr.length-1,metrics);

        System.out.println(Arrays.toString(arr));

        Arrays.sort(copy);
        assertArrayEquals(copy,arr);

    }
    
}
