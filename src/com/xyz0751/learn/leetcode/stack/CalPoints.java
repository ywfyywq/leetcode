package com.xyz0751.learn.leetcode.stack;

import java.util.Stack;

public class CalPoints {
    public int calPoints(String[] ops) {
        Stack<Integer> points = new Stack<>();
        for(String s : ops) {
            if ("C".equals(s)) {
                points.pop();
            } else if ("D".equals(s)) {
                Integer point = points.peek();
                points.push(2*point);
            } else if ("+".equals(s)) {
                Integer point = points.pop();
                Integer newPoint = point + points.peek();
                points.push(point);
                points.push(newPoint);
            } else {
                points.push(Integer.valueOf(s));
            }
        }

        Integer sum = 0;
        while (!points.isEmpty()) {
            sum += points.pop();
        }

        return sum;
    }

    public static void main(String[] args) {
        CalPoints calPoints = new CalPoints();
        System.out.println(calPoints.calPoints(new String[] {"5","-2","4","C","D","9","+","+"}));
    }
}
