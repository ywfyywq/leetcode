package com.xyz0751.learn.leetcode.dp;

public class NumArray {
    int[] nums = null;

    public NumArray(int[] nums) {
        this.nums = nums;
        for (int i=1; i<nums.length; i++) {
            nums[i] = nums[i] + nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        if (left > 0) {
            return nums[right] - nums[left-1];
        } else {
            return nums[right];
        }
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0,2));
        System.out.println(numArray.sumRange(2,5));
        System.out.println(numArray.sumRange(0,5));
    }
}
