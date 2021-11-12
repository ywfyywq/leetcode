package com.xyz0751.learn.leetcode.binarysearch;

/**
 * 209. 长度最小的子数组
 *
 * 难度 中等
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 *  
 *
 * 进阶：
 *
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int min = 0;
        int start = 0;
        int current=0;
        for (int i=0; i<nums.length; i++) {
            current += nums[i];
            if (current >= target) {
                if (min == 0) {
                    min = (i-start+1);
                } else {
                    min = Math.min(i-start+1, min);
                }
                do {
                    min = Math.min(i-start+1, min);
                    current -= nums[start++];
                } while(current >= target);
            }
        }

        return min;
    }

    public static void main(String[] args) {
        MinSubArrayLen algo = new MinSubArrayLen();
//        System.out.println(algo.minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
//        System.out.println(algo.minSubArrayLen(4, new int[] {1,4,4}));
//        System.out.println(algo.minSubArrayLen(11, new int[] {1,1,1,1,1,1,1,1}));
        System.out.println(algo.minSubArrayLen(11, new int[] {1,2,3,4,5}));
    }
}
