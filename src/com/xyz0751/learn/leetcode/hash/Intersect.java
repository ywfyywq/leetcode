package com.xyz0751.learn.leetcode.hash;

import com.xyz0751.learn.leetcode.utils.ArrayUtils;

import java.util.*;

/**
 * 350. 两个数组的交集 II
 *
 * 难度 简单
 *
 * 给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * 
 *
 * 提示：
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * 
 *
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果nums1的大小比nums2 小，哪种方法更优？
 * 如果nums2的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        while(index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                list.add(nums1[index1]);
                index1++;
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }

        if (list.size() == 0) {
            return new int[0];
        } else {
            int [] ans = new int[list.size()];
            for (int i=0; i<list.size(); i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Intersect algo = new Intersect();
        ArrayUtils.print(algo.intersect(new int[]{1,2,2,1}, new int[] {2,2}));
        ArrayUtils.print(algo.intersect(new int[]{4,9,5}, new int[] {9,4,9,8,4}));
    }
}
