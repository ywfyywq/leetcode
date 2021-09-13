package com.xyz0751.learn.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int a = 1;
        int b = 2;
        int result = 0;
        for (int i=2; i<n; i++) {
            result = a + b;
            a = b;
            b = result;
        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(climbStairs(10000000));
        System.out.println(climbStairs(1000));
    }
}
