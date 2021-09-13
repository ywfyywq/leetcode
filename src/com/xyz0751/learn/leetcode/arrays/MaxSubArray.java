package com.xyz0751.learn.leetcode.arrays;

public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int max = nums[0];
        int temp = max;
        for (int i=1; i<nums.length; i++) {
            if (temp > 0) {
                temp += nums[i];
            } else {
                temp = nums[i];
            }
            if (max < temp) {
                max = temp;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4});
    }
}
