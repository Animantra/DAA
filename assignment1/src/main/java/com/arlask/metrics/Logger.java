package com.arlask.metrics;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private final String fileName;

    public Logger(String fileName){
        this.fileName = fileName;
        try(PrintWriter p = new PrintWriter(new FileWriter(fileName))){
            p.println("algorithm,n,timeMs,comparisons,swaps,maxDepth");
        }
        
        catch(IOException e) {
        e.printStackTrace();
        }
    }
    public void log(String algorithm, int n, long timeMs,Metrics metrics){
            try (PrintWriter pw = new PrintWriter(new FileWriter(fileName, true))) {
            pw.printf("%s,%d,%d,%d,%d,%d%n",
                    algorithm, n, timeMs,
                    metrics.getComparisons(),
                    metrics.getSwaps(),
                    metrics.getMaxDepth());
        } catch (IOException e) {
            throw new RuntimeException("Failed to write CSV line", e);
        }
    }
}
