package com.arlask;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.junit.jupiter.api.Test;

import com.arlask.metrics.Metrics;

public class DeterSelectTests{
    @Test
    void deterTest(){
        Metrics metrics = new Metrics();
        metrics.reset();
        int[] arr = new int[100];
        Random random=new Random();
        for(int i=0;i<arr.length;i++){
            arr[i]=random.nextInt(100) * (random.nextBoolean() ? 1 :-1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int v : arr) list.add(v);

        ArrayList<Integer> sorted = new ArrayList<>(list);
        Collections.sort(sorted);

        for (int k = 0; k < arr.length; k++) {
            ArrayList<Integer> copyList = new ArrayList<>(list); 
            int result = DeterSelect.Select(copyList, k,metrics);
            assertEquals(sorted.get(k), result, "Error for k=" + k);
        }

        int medianIndex = arr.length / 2;
        ArrayList<Integer> copyListForMedian = new ArrayList<>(list);
        int median = DeterSelect.Select(copyListForMedian, medianIndex,metrics);
        assertEquals(sorted.get(medianIndex), median, "Error for median");

    }
}