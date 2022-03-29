package hw2;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private int times;
    private int size;
    private double[] counts;
    private Percolation temp;
    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new java.lang.IllegalArgumentException();
        }
        times = T;
        size = N;
        counts = new double[T];
        for (int j = 0; j < T; j += 1) {
            temp = pf.make(size);
            counts[j] = simulation(temp);
        }
    }

    private double simulation(Percolation simu) {
        while (!simu.percolates()) {
            int row = StdRandom.uniform(size);
            int col = StdRandom.uniform(size);
            simu.open(row, col);
        }
        return (double) simu.numberOfOpenSites() / (size * size);
    }

    public double mean() {
        return StdStats.mean(counts);
    }
    public double stddev() {
        return StdStats.stddev(counts);
    }
    public double confidenceHigh() {
        return mean() + 1.96 * stddev() / Math.sqrt(times);
    }

    public double confidenceLow() {
        return mean() - 1.96 * stddev() / Math.sqrt(times);
    }
}
