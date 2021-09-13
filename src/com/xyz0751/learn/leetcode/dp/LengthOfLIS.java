package com.xyz0751.learn.leetcode.dp;

public class LengthOfLIS {
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i=1; i<nums.length; i++) {
            int j = i-1;
            dp[i] = 1;
            do {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            } while(--j>=0);
            max = Math.max(dp[i], max);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,4,5,6,3,7,101,18}));
    }
}
