package org.example;

import java.util.Random;

public class Main {
    private static boolean[][] arr;
    private static Pair a;
    private static Pair b;
    private static Pair c;
    private static Pair d;
    private static int iterationCount;
    private static final Random random = new Random();

    public static void setup() {
        iterationCount = 10000;
        int size = 30; // height

        arr = new boolean[size * 4][size];
        a = new Pair(0, 0);
        b = new Pair(arr.length / 2, arr[0].length - 1);
        c = new Pair(arr.length - 1, 0);
        d = new Pair(arr.length / 2, arr[0].length / 2);
    }

    public static void main(String[] args) {
        setup();

        mark(a);
        mark(b);
        mark(c);
        mark(d);

        for (int i = 0; i < iterationCount; i++) {
            random();
        }
        printArr();
    }

    private static void mark(Pair pair) {
        arr[pair.x][pair.y] = true;
    }

    private static void random() {
        int x = random.nextInt(3);
        switch (x) {
            case 0 -> d = Pair.vectorSum(a, d);
            case 1 -> d = Pair.vectorSum(b, d);
            default -> d = Pair.vectorSum(c, d);
        }
        mark(d);
    }

    private static void printArr() {
        for (int j = arr[0].length - 1; j >= 0; j--) {
            System.out.print("\n");
            for (boolean[] lineArr : arr) {
                String s = " ";
                if (lineArr[j]) {
                    s = "*";
                }
                System.out.print(s);
            }
        }
    }
}