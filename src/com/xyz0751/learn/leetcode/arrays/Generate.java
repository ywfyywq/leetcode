package com.xyz0751.learn.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class Generate {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<numRows; i++) {
            List<Integer> row = new ArrayList<>();
            if (i==0) {
                row.add(1);
            } else {
                row.add(1);
                for (int j = 1; j < i; j++) {
                    List<Integer> preRow = result.get(i-1);
                    row.add(preRow.get(j-1) + preRow.get(j));
                }
                row.add(1);
            }
            result.add(row);
        }
        return result;
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex);
        for(int i=0; i<rowIndex; i++) {
            if (i==0) {
                result.add(1);
            } else {
                result.set(0, 1);
                Integer preNum = 1;
                for (int j = 1; j < i; j++) {
                    int current = result.get(j);
                    if (result.size() > j) {
                        result.set(j, preNum + current);
                    } else {
                        result.add(preNum + current);
                    }
                    preNum = current;
                }
                result.add(1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(6));
        System.out.println(getRow(6));
    }
}
