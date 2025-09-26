package com.arlask;

import java.util.ArrayList;
import java.util.Collections;

import com.arlask.metrics.Metrics;



public class DeterSelect{
        
        public static int Select(ArrayList<Integer> arr,int k,Metrics metrics) {
            metrics.enterRec();
            int n=arr.size();

            ArrayList<ArrayList<Integer>> groups=new ArrayList<>();

            if(n<=5){
                Collections.sort(arr);
                metrics.incSwaps();
                metrics.leaveRec();
                return arr.get(k);
            }

            for(int i=0;i<n;i+=5){
                int end=Math.min(i+5,n);
                ArrayList<Integer> group=new ArrayList<>(arr.subList(i, end));
                groups.add(group);
                metrics.incSwaps();
            }
            int pivot = pivotSelect(groups, metrics);

            ArrayList<Integer> left=new ArrayList<>();
            ArrayList<Integer> equal=new ArrayList<>();
            ArrayList<Integer> right=new ArrayList<>();

            for(int i=0;i<arr.size();i++){
                int value =arr.get(i);
                metrics.incComparisons();
                if(value<pivot){
                    left.add(value);
                    metrics.incSwaps();
                }
                else if(value>pivot) {
                    metrics.incComparisons();
                    right.add(value);
                    metrics.incSwaps();
                }
                else{
                    equal.add(value);
                    metrics.incSwaps();
                }
            }

            int result;
            if(k<left.size()){
                metrics.incComparisons();
                result = Select(left,k,metrics);
            } else if(k<left.size() + equal.size()){
                metrics.incComparisons();
                result=pivot;
            } else{
                metrics.incComparisons();
                result = Select(right,k-left.size()-equal.size(),metrics);
            }
            metrics.leaveRec();
            return result;
        }

        public static int pivotSelect(ArrayList<ArrayList<Integer>> groups,Metrics metrics){
            ArrayList<Integer> medians=new ArrayList<>();

            for(ArrayList<Integer> group : groups){
                Collections.sort(group);
                int median=group.get(group.size()/2);
                medians.add(median);
            }

            if(medians.size()<=5){
                Collections.sort(medians);
                return medians.get(medians.size()/2);
            }

            return Select(medians,medians.size()/2,metrics);
            

        }
}