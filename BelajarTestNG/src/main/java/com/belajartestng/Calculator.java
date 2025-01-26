package com.belajartestng;

public class Calculator {
    public static int add(int x, int y){
        return x + y;
    }

    public static int subtract (int x, int y){
        return x - y;
    }

    public static int multiplication (int x, int y){
        return x * y;
    }

    public static int division (int x, int y){
        return x / y;
    }

    public static int mod (int x, int y){
        return x % y;
    }

    public static double hitungBMI(double BB, double TB){
        return BB / (TB * TB);
    }
}
