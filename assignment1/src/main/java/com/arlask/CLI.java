package com.arlask;

import com.arlask.metrics.Logger;
import com.arlask.metrics.Metrics;

import java.util.ArrayList;
import java.util.Random;

public class CLI {
    public static void main(String[] args) {
        

        String algoritm=args[0];
        int n = Integer.parseInt(args[1]);

        int [] arr=new int[n];
        Random rn=new Random();
        for(int i=0;i<n;i++){
            arr[i]=rn.nextInt(100);
        }

        int [] buffer=new int[n];
        Metrics metrics=new Metrics();
        metrics.reset();

        Logger logger=new Logger("results.csv");

        long start=System.nanoTime();

        if(algoritm.equalsIgnoreCase("mergesort")){
            MergeSortAlg.mergesort(arr, buffer, 0, n-1, metrics);
        }
        else if(algoritm.equalsIgnoreCase("quicksort")){
            QuickSort.quicksort(arr, 0, n-1, metrics);
        }
        else if(algoritm.equalsIgnoreCase("deterselect")){
            ArrayList<Integer> arrList=new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                arrList.add(arr[i]);
            }
            System.out.println("Enter k:");
            int k = Integer.parseInt(args[2]);
            int result=DeterSelect.Select(arrList, k, metrics);

            System.out.println("DeterSelect k= " + k +"result" + result);
        }
        else if(algoritm.equalsIgnoreCase("closestpair")){
             Point[] points = new Point[n];
            for (int i = 0; i < n; i++) {
                points[i] = new Point(rn.nextInt(100), rn.nextInt(100));
            }

            double minDist = ClosestPair.Closest(points, n,metrics);
            System.out.println("Closest pair distance = " + minDist);
        }

        long end=System.nanoTime();
        long timeMs=(end-start)/1000000;

        logger.log(algoritm, n, timeMs, metrics);

    }
}
