package com.arlask.metrics;

public class Metrics {
    int comparisons;
    int currentDepth;
    int swaps;
    int maxDepth;

    public void reset(){
        comparisons=0;
        currentDepth=0;
        swaps=0;
        maxDepth=0;

    }

    public void incComparisons(){
        comparisons++;

    }

    public void incSwaps(){
        swaps++;

    }

    public void enterRec(){
        currentDepth++;
        if(currentDepth>maxDepth){
            maxDepth=currentDepth;
        }

    }
     public void leaveRec(){
        currentDepth--;
    }

    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

   


    
}
