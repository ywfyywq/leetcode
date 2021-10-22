package com.xyz0751.learn.leetcode.greedy;

import java.util.Arrays;

/**
 * 976. 三角形的最大周长
 *
 * 难度 简单
 *
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 *
 * 如果不能形成任何面积不为零的三角形，返回  0。
 *
 *   
 *
 * 示例 1：
 *
 * 输入：[2,1,2]
 * 输出：5
 * 示例 2：
 *
 * 输入：[1,2,1]
 * 输出：0
 * 示例 3：
 *
 * 输入：[3,2,3,4]
 * 输出：10
 * 示例 4：
 *
 * 输入：[3,6,2,3]
 * 输出：8
 *   
 *
 * 提示：
 *
 * 3 <= A.length <= 10000
 * 1 <= A[i] <= 10^6
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-perimeter-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestPerimeter {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int index = nums.length-1;
        int a = nums[index--];
        int b = nums[index--];
        int c = nums[index--];
        do {
            if (a+b > c && b+c > a && a+c > b) {
                return a+b+c;
            } else if (index >= 0){
                a = b;
                b = c;
                c = nums[index--];
            } else {
                return 0;
            }
        } while (index >= -1);

        return 0;
    }

    public static void main(String[] args) {
        LargestPerimeter lp = new LargestPerimeter();
        System.out.println(lp.largestPerimeter(new int[] {2,1,2}));
        System.out.println(lp.largestPerimeter(new int[] {1,2,1}));
        System.out.println(lp.largestPerimeter(new int[] {3,2,3,4}));
        System.out.println(lp.largestPerimeter(new int[] {3,6,2,3}));
    }
}
