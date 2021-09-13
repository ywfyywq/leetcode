package com.xyz0751.learn.leetcode.dp;

public class DivisorGame {
    public static boolean divisorGame(int n) {
        return n % 2 == 0;
    }

    public static void main(String[] args) {
        System.out.println(divisorGame(500));
    }
}
