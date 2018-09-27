package com.matao;

/**
 * Created by matao on 2018/9/27.
 */
public class Accumulator {
    private double total;
    private int N;

    public void addDataValue(double val) {
        N++;
        total += val;
    }

    public double mean() {
        return total / N;
    }

    @Override
    public String toString() {
        return "Mean (" + N + " values): " + String.format("%7.5f", mean());
    }

    public static void main(String[] args) {
        Accumulator accumulator = new Accumulator();
        accumulator.addDataValue(1);
        accumulator.addDataValue(2);
        accumulator.addDataValue(3);
        accumulator.addDataValue(4);
        accumulator.addDataValue(5);
        System.out.println(accumulator.toString());
    }
}
