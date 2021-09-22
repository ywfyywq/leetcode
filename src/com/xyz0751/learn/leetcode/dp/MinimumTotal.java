package com.xyz0751.learn.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. 三角形最小路径和
 *
 * 难度 中等
 *
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 示例 2：
 *
 * 输入：triangle = [[-10]]
 * 输出：-10
 *  
 *
 * 提示：
 *
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 *  
 *
 * 进阶：
 *
 * 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
 *
 * @author YY
 */
public class MinimumTotal {
    public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 1 ) {
            return triangle.get(0).get(0);
        }

        int[] cost = new int[triangle.get(triangle.size()-1).size()];
        cost[0] = triangle.get(0).get(0);
        int min = cost[0];
        int row = triangle.size();
        for(int i=1; i<row; i++) {
            int col = triangle.get(i).size();
            for (int j=col-1; j>=0; j--) {
                int temp = 0;
                int val = triangle.get(i).get(j);
                if (j == 0) {
                    temp = cost[j] + val;
                } else if (j==col-1) {
                    temp = cost[j-1] + val;
                } else {
                    temp = cost[j-1] < cost[j] ? cost[j-1] + val : cost[j] + val ;
                }
                cost[j] = temp;
                if (j == col-1) {
                    min = cost[j];
                } else if (cost[j] < min) {
                    min = cost[j];
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        List root = new ArrayList();
        List<Integer> row1 = new ArrayList<>();
        row1.add(2);
        root.add(row1);

        List<Integer> row2 = new ArrayList<>();
        row2.add(3);
        row2.add(4);
        root.add(row2);

        List<Integer> row3 = new ArrayList<>();
        row3.add(6);
        row3.add(5);
        row3.add(7);
        root.add(row3);

        List<Integer> row4 = new ArrayList<>();
        row4.add(4);
        row4.add(1);
        row4.add(8);
        row4.add(3);
        root.add(row4);

        System.out.println(minimumTotal(root));

    }
}
