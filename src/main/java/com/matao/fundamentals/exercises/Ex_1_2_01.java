package com.matao.fundamentals.exercises;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by matao on 2018/9/28.
 * <p>
 * Write a Point2D client that takes an integer value N from the command line,
 * generates N random points in the unit square,
 * and computes the distance separating the closest pair of points.
 */
public class Ex_1_2_01 {

    public static void main(String[] args) {
        int N = (int) (Math.random() + 10);
        Point2D[] points = new Point2D[N];
        for (int i = 0; i < N; i++) {
            points[i] = new Point2D(Math.random(), Math.random());
            points[i].draw();
        }
        if (N > 1) {
            double min = points[0].distanceTo(points[1]);
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (points[i].distanceTo(points[j]) < min) {
                        min = points[i].distanceTo(points[j]);
                    }
                }
            }
            StdOut.printf("Min distance: %f", min);
        }
    }
}
