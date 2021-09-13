package com.xyz0751.learn.leetcode.dp;

public class Rob {
    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int curMax = 0;
        int preMax = 0;
        int temp = 0;
        for (int i=0; i<nums.length; i++) {
            temp = curMax;
            curMax = Math.max(nums[i] + preMax, curMax);
            preMax = temp;
        }

        return curMax;
    }

    public static int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int curMax = 0;
        int preMax = 0;
        int temp = 0;

        int curMax2 = 0;
        int preMax2 = 0;
        int temp2 = 0;
        for (int i=0; i<nums.length; i++) {
            if (i < nums.length-1) {
                temp = curMax;
                curMax = Math.max(nums[i] + preMax, curMax);
                preMax = temp;
            }
            if (i > 0) {
                temp2 = curMax2;
                curMax2 = Math.max(nums[i] + preMax2, curMax2);
                preMax2 = temp2;
            }
        }

        return Math.max(curMax, curMax2);
    }

    public static void main(String[] args) {
        System.out.println(rob2(new int[]{1,2,3,1}));
    }
}
