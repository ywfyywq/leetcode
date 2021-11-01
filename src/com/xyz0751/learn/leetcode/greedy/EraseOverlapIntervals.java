package com.xyz0751.learn.leetcode.greedy;

import java.util.Arrays;

/**
 * 435. 无重叠区间
 *
 * 难度 中等
 *
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 *
 * 输入: [ [1,2], [1,2], [1,2] ]
 *
 * 输出: 2
 *
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 *
 * 输入: [ [1,2], [2,3] ]
 *
 * 输出: 0
 *
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }

        // [0,1][2,10][3,4][5,6]
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });

        int count = 0;
        int[] temp = intervals[0];
        for (int i=1; i<intervals.length; i++) {
            if (intervals[i][0] < temp[1]) {
                count++;
            } else {
                temp = intervals[i];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        EraseOverlapIntervals algo = new EraseOverlapIntervals();
        System.out.println(algo.eraseOverlapIntervals(new int[][]{{1,2}, {2,3}, {3,4}, {1,3}}));
        System.out.println(algo.eraseOverlapIntervals(new int[][]{{1,2}, {1,2}, {1,2}}));
        System.out.println(algo.eraseOverlapIntervals(new int[][]{{1,2}, {2,3}}));
        System.out.println(algo.eraseOverlapIntervals(new int[][]{{1,2}, {2,10}, {3,4},{4,5}}));
    }
}