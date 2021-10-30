package com.xyz0751.learn.leetcode.greedy;

import java.util.Arrays;

/**
 * 452. 用最少数量的箭引爆气球
 *
 * 难度 中等
 *
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 *
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 *
 * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 *
 *  
 * 示例 1：
 *
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
 * 示例 2：
 *
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * 示例 3：
 *
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 示例 4：
 *
 * 输入：points = [[1,2]]
 * 输出：1
 * 示例 5：
 *
 * 输入：points = [[2,3],[2,3]]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= points.length <= 104
 * points[i].length == 2
 * -231 <= xstart < xend <= 231 - 1
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMinArrowShots {

    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1) {
            return points.length;
        }

        Arrays.sort(points, (int[] a, int[] b) -> {
            if (a[0] != b[0]) {
                if (a[0] > 0 && b[0] < 0) {
                    if (Integer.MAX_VALUE + b[0] < a[0]) {
                        return Integer.MAX_VALUE;
                    }
                } else if (a[0] < 0 && b[0] > 0){
                    if (Integer.MIN_VALUE + b[0] > a[0]) {
                        return Integer.MIN_VALUE;
                    }
                }
                return a[0] - b[0];
            } else {
                if (a[1] > 0 && b[1] < 0) {
                    if (Integer.MAX_VALUE + a[1] < b[1]) {
                        return Integer.MAX_VALUE;
                    }
                } else if (a[1] < 0 && b[1] > 0){
                    if (Integer.MIN_VALUE + b[1] > a[1]) {
                        return Integer.MIN_VALUE;
                    }
                }
                return b[1] - a[1];
            }
        });

        int maxRight = points[0][1];
        int count = 1;
        for (int i=1; i<points.length; i++) {
            if (points[i][0] > maxRight) {
                maxRight = points[i][1];
                count++;
            } else {
                maxRight = Math.min(maxRight, points[i][1]);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        FindMinArrowShots algo = new FindMinArrowShots();

//        System.out.println(algo.findMinArrowShots(new int[][] { {10,16 }, {2,8 }, {1,6 }, {7,12 }}));
//        System.out.println(algo.findMinArrowShots(new int[][] { {1,2 }, {3,4 }, {5,6 }, {7,8 }}));
//        System.out.println(algo.findMinArrowShots(new int[][] { {1,2 }, {2,3 }, {3,4 }, {4,5 }}));
//        System.out.println(algo.findMinArrowShots(new int[][] { {1,2 }}));
//        System.out.println(algo.findMinArrowShots(new int[][] { {2,3}, {2,3}}));
        System.out.println(algo.findMinArrowShots(new int[][] { {-2147483646,-2147483645},{2147483646,2147483647}}));

    }
}
