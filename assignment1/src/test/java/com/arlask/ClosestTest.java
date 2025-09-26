package com.arlask;


import org.junit.jupiter.api.Test;

import com.arlask.metrics.Metrics;
public class ClosestTest {
    Metrics metrics =new Metrics();
    @Test
     void closeTest(){
        Point[] P = { new Point(2, 3), new Point(12, 30), new Point(40, 50), 
                      new Point(5, 1), new Point(12, 10), new Point(3, 4) };
        int n = P.length;

       System.out.println("The smallest distance is " + ClosestPair.Closest(P, n,metrics));
    }
}
