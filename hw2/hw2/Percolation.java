package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int N;
    private int NumOfOpen = 0;
    private int topRoot;
    private int bottomRoot;
    private WeightedQuickUnionUF model;
    private int[] Sites;

    public Percolation(int N) {
        Sites = new int[N * N];
        topRoot = N * N;
        bottomRoot = N * N + 1;
        this.N = N;
        if (N <= 0) {
            throw new java.lang.IllegalArgumentException();
        } else {
            model = new WeightedQuickUnionUF(N * N + 2);
        }
    }

    private boolean OutOfDex(int row, int col) {
        return (row < 0 || col < 0 || row >= N || col >= N);
    }
    private int xyTo1D(int row, int col) {
        return row * N + col;
    }

    public void open(int row, int col) {
        if (OutOfDex(row, col)) {
            throw new java.lang.IndexOutOfBoundsException();
        } else {
            if (isOpen(row, col)) {
                return ;
            }
            NumOfOpen += 1;
            int Num = xyTo1D(row, col);
            Sites[Num] = 1;
            if (Num < N) {
                model.union(Num, topRoot);
            }
            if (row == N - 1) {
                if (isFull(row, col)) {
                    model.union(Num, bottomRoot);
                }
            }
            int[] around = new int[4];
            around[0] = xyTo1D(row - 1, col);
            around[1] = xyTo1D(row, col + 1);
            around[2] = xyTo1D(row + 1, col);
            around[3] = xyTo1D(row, col - 1);
            if (!OutOfDex(row - 1, col) && isOpen(row - 1, col)) {
                model.union(Num, around[0]);
            }
            if (!OutOfDex(row, col + 1) && isOpen(row, col + 1)) {
                model.union(Num, around[1]);
            }
            if (!OutOfDex(row + 1, col) && isOpen(row + 1, col)) {
                model.union(Num, around[2]);
            }
            if (!OutOfDex(row, col - 1) && isOpen(row, col - 1)) {
                model.union(Num, around[3]);
            }
        }
    }

    public boolean isOpen(int row, int col) {
        if (OutOfDex(row, col)) {
            throw new java.lang.IndexOutOfBoundsException();
        } else {
            int Num = xyTo1D(row, col);
            return (Sites[Num] == 1);
        }
    }

    public boolean isFull(int row, int col) {
        if (OutOfDex(row, col)) {
            throw new java.lang.IndexOutOfBoundsException();
        } else {
            int Num = xyTo1D(row, col);
            return model.connected(Num, topRoot);
        }
    }

    public int numberOfOpenSites() {
        return NumOfOpen;
    }

    public boolean percolates() {
        return model.connected(topRoot, bottomRoot);
    }

    public static void main(String[] args) {
        Percolation world = new Percolation(20);
        world.open(3, 4);
        world.open(2, 4);
    }
}
