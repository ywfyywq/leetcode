package com.xyz0751.learn.leetcode.dp;

public class Massage {
    public static int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int max1 = nums[0];
        int max2 = nums[1];
        int temp;
        for(int i=2; i<nums.length; i++) {
            temp = max2;
            max2 = max1 + nums[i];
            max1 = temp > max1 ? temp : max1;
        }
        return max1 > max2 ? max1 : max2;
    }

    public static void main(String[] args) {
        System.out.println(massage(new int[] {1,2,3,1}));
        System.out.println(massage(new int[] {2,7,9,3,1}));
        System.out.println(massage(new int[] {2,1,4,5,3,1,1,3}));
        System.out.println(massage(new int[]{2,1,1,2}));
    }
}
