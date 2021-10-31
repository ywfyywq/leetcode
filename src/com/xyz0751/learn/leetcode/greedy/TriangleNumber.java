package com.xyz0751.learn.leetcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 611. 有效三角形的个数
 *
 * 难度 中等
 *
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 *
 * 示例 1:
 *
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 注意:
 *
 * 数组长度不超过1000。
 * 数组里整数的范围为 [0, 1000]。
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-triangle-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TriangleNumber {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);

        int count = 0;
        for (int i=0; i<nums.length-2; i++) {
            for (int j=i+1; j<nums.length-1; j++) {
                for (int k=j+1; k<nums.length; k++) {
                    if (nums[i] + nums[j] > nums[k]) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        TriangleNumber algo = new TriangleNumber();
//        System.out.println(algo.triangleNumber(new int[] {2,2,3,4}));
        System.out.println(algo.triangleNumber(new int[] {4,2,3,4}));
    }
}
