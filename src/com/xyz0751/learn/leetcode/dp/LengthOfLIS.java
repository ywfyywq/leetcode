package com.xyz0751.learn.leetcode.dp;

/**
 * 300. 最长递增子序列
 * 难度 中等
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 
 * 示例 1：
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 *
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * 
 *
 * 提示：
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 * 
 *
 * 进阶：
 *
 * 你可以设计时间复杂度为 O(n2) 的解决方案吗？
 * 你能将算法的时间复杂度降低到O(n log(n)) 吗?
 *
 */
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
