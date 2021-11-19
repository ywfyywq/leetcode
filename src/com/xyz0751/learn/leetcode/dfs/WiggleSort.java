package com.xyz0751.learn.leetcode.dfs;

import com.xyz0751.learn.leetcode.utils.ArrayUtils;

import java.util.Arrays;

/**
 * 324. 摆动排序 II
 *
 * 难度 中等
 *
 * 给你一个整数数组   nums，将它重新排列成   nums[0] < nums[1] > nums[2] < nums[3]...   的顺序。
 *
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 *
 *    
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,1,1,6,4]
 * 输出：[1,6,1,5,1,4]
 * 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
 * 示例 2：
 *
 * 输入：nums = [1,3,2,2,3,1]
 * 输出：[2,3,1,3,1,2]
 *    
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 104
 * 0 <= nums[i] <= 5000
 * 题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果
 *    
 *
 * 进阶：你能用   O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wiggle-sort-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        Arrays.sort(nums);
        int half = nums.length % 2 == 0 ? nums.length/2-1 : nums.length/2;
        reverse(nums, 0, half);
        reverse(nums, half+1, nums.length-1);
        int[] newNums = new int[nums.length];
        int index=0,i=0,j=0;
        while (i<=half&&(half+1+j)<nums.length) {
            newNums[index] = index % 2 == 0 ? nums[i++] : nums[half+1+j++];
            index++;
        }
        while (i <= half) {
            newNums[index++] = nums[i++];
        }
        while ((half+1+j)<nums.length) {
            newNums[index++] = nums[half+1+j++];
        }
        for (int k=0; k<nums.length; k++) {
            nums[k] = newNums[k];
        }
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        WiggleSort algo = new WiggleSort();
        int[] nums = new int[] {2,1};
        algo.wiggleSort(nums);
        ArrayUtils.print(nums);
    }
}
