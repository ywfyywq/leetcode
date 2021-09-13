package com.xyz0751.learn.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

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
