package com.xyz0751.learn.leetcode.mergesort;

import com.xyz0751.learn.leetcode.utils.ArrayUtils;

/**
 * 912. 排序数组
 *
 * 难度 中等
 *
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortArray {
    public int[] sortArray(int[] nums) {
        return sortArray(nums, 0, nums.length-1);
    }

    public int[] sortArray(int[] nums, int start, int end) {
        if (start > end) {
            return new int[]{};
        } else if (start == end){
            return new int[]{nums[start]};
        }

        int mid = start + (end - start)/2;
        int[] nums1 = sortArray(nums, start, mid);
        int[] nums2 = sortArray(nums, mid+1, end);
        return mergeArray(nums1, nums2);
    }

    public int[] mergeArray(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return new int[]{};
        }

        int[] nums = new int[nums1.length + nums2.length];
        int i=0,j=0,index=0;
        while(i<nums1.length && j<nums2.length) {
            if (nums1[i] <= nums2[j]) {
                nums[index++] = nums1[i++];
            } else {
                nums[index++] = nums2[j++];
            }
        }

        while(i<nums1.length) {
            nums[index++] = nums1[i++];
        }
        while(j<nums2.length) {
            nums[index++] = nums2[j++];
        }
        return nums;
    }

    public static void main(String[] args) {
        SortArray algo = new SortArray();
        ArrayUtils.print(algo.sortArray(new int[]{5,2,3,1}));
        ArrayUtils.print(algo.sortArray(new int[]{5,1,1,2,0,0}));
    }
}
