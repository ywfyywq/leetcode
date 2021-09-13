package com.xyz0751.learn.leetcode.arrays;

import com.xyz0751.learn.leetcode.utils.ArrayUtils;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        if (digits[0] == 0) {
            digits[0] += 1;
            return digits;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 <= 9) {
                digits[i] += 1;
                return digits;
            } else if (i > 0) {
                digits[i] = 0;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        ArrayUtils.print(plusOne(new int[] {9,9,9}));
    }
}
