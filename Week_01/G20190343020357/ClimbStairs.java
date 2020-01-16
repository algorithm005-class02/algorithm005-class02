package com.array.review;

public class ClimbStairs {

    public static int climbStairs(int n) {
        int f1 = 1;
        int f2 = 2;
        int f3 = 3;
        int result = 0;
        if (n < 3) {
            return n;
        } else {
            for (int i = 3; i <= n; i++) {
                result = f2 + f1;
                f1 = f2;
                f2 = result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
