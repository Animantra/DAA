package com.arlask;

import java.util.Arrays;
import java.util.List;

import com.arlask.metrics.Metrics;

import java.util.ArrayList;

class Point {
public int x;
public int y;

public Point(int x, int y) {
    this.x = x;
    this.y = y;
}
}

public class ClosestPair {
    Metrics metrics=new Metrics();

    
    
    public static double Closest(Point[] P, int n,Metrics metrics) {
        Point[] Px = Arrays.copyOf(P, n);
        Arrays.sort(Px, (p1, p2) -> p1.x - p2.x);
        Point[] Py = Arrays.copyOf(P, n);
        Arrays.sort(Py, (p1, p2) -> p1.y - p2.y);
        
        return ClosestUtil(Px, Py, n,metrics);
    }

    private static double ClosestUtil(Point[] Px, Point[] Py, int n,Metrics metrics) {
        metrics.enterRec();
        
        if (n <= 3) {
            double res= BruteForce(Px, n,metrics);
            metrics.leaveRec();
            return res;
        }
        int mid = n / 2;
        Point midPoint = Px[mid];
        
       
        Point[] Pyl = Arrays.copyOfRange(Py, 0, mid);
        Point[] Pyr = Arrays.copyOfRange(Py, mid, n);
       
        double dl = ClosestUtil(Px, Pyl, mid,metrics);
        double dr = ClosestUtil(Arrays.copyOfRange(Px, mid, n), Pyr, n - mid,metrics);
    
        double d = Math.min(dl, dr);
    
        
        List<Point> strip = new ArrayList<Point>();
        for (Point p : Py) {
            if (Math.abs(p.x - midPoint.x) < d) {
                strip.add(p);
            }
        }
    
        return StripClosest(strip.toArray(new Point[strip.size()]), strip.size(), d,metrics);
    }
    
    private static double BruteForce(Point[] P, int n,Metrics metrics) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                metrics.incComparisons();
                double dist = distance(P[i], P[j]);
                if (dist < min) {
                    min = dist;
                }
            }
        }
        return min;
    }
    
    private static double StripClosest(Point[] strip, int size, double d,Metrics metrics) {
        double min = d; 

        for (int i = 0; i < size; ++i) {
            for (int j = i + 1; j < size && (strip[j].y - strip[i].y) < min; ++j) {
                double dist = distance(strip[i], strip[j]);
                if (dist < min) {
                    min = dist;
                }
            }
        }
        return min;
    }

    private static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
   
}

