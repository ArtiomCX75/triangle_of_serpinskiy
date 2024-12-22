package org.example;

public class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Pair vectorSum(Pair a, Pair b) {
        int x = (a.x + b.x) / 2;
        int y = (a.y + b.y) / 2;
        return new Pair(x, y);
    }
}
