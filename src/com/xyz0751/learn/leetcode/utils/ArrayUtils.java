package com.xyz0751.learn.leetcode.utils;

public final class ArrayUtils {
    private ArrayUtils() {}

    public static void print(int[] arrays) {
        for (int i=0; i< arrays.length; i++) {
            System.out.print(arrays[i] + ",");
        }
        System.out.println();
    }
}
