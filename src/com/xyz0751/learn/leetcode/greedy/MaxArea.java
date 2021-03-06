package com.xyz0751.learn.leetcode.greedy;

/**
 * 11. 盛最多水的容器
 *
 * 难度 中等
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49 
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 *
 * 输入：height = [1,1]
 * 输出：1
 * 示例 3：
 *
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 * 示例 4：
 *
 * 输入：height = [1,2,1]
 * 输出：2
 *  
 *
 * 提示：
 *
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 * 通过次数550,607提交次数878,635
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxArea {
    public int maxArea2(int[] height) {
        int max = 0;
        if (height.length < 1) {
            return max;
        }

        if (height.length == 1) {
            return height[0];
        }

        int left = 0;
        int maxIndex = height[0] > height[1] ? 0 : 1;
        max = Math.min(height[0], height[1])*1;
        for (int i=2; i< height.length; i++) {
            int val1 = Math.min(height[i], height[left])*(i-left);
            if (val1 > max) {
                max = val1;
            }
            int val2 = Math.min(height[i], height[maxIndex])*(i-maxIndex);
            if (val2 > max) {
                max = val2;
                left = maxIndex;
            }

            if (height[i] > height[maxIndex]) {
                maxIndex = i;
            }
        }

        return max;
    }

    /**
     * 双指针
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;

        while(left < right) {
            max = Math.max(max, Math.min(height[left], height[right])*(right - left));
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxArea ma = new MaxArea();
        System.out.println(ma.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
        System.out.println(ma.maxArea(new int[] {1,1}));
        System.out.println(ma.maxArea(new int[] {4,3,2,1,4}));
        System.out.println(ma.maxArea(new int[] {1,2,1}));

        System.out.println(ma.maxArea(new int[] {1,2,3,4}));
    }
}
