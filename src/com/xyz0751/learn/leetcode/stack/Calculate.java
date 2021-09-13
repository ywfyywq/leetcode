package com.xyz0751.learn.leetcode.stack;

import java.util.Stack;
import java.util.StringTokenizer;

public class Calculate {
    public int calculate(String s) {
        String newStr = s.replace(" ", "");
        char[] chars = newStr.toCharArray();
        String preSign = null;
        Integer num = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<chars.length; i++) {
            char c =chars[i];
            if (c == '+' || c == '-' || c == '*' || c ==  '/' || i == chars.length-1) {
                if (i == chars.length - 1) {
                    num = num * 10 + Integer.valueOf(c+"");
                }

                if ("*".equals(preSign)) {
                    stack.push(stack.pop()*num);
                } else if ("/".equals(preSign)) {
                    stack.push(stack.pop()/num);
                } else if ("-".equals(preSign)) {
                    stack.push(-1*num);
                } else {
                    stack.push(num);
                }
                preSign = c+"";
                num = 0;
            } else {
                num = num * 10 + Integer.valueOf(c+"");
            }
        }

        Integer result = stack.pop();
        while (!stack.isEmpty()) {
            result = result + stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        Calculate c = new Calculate();
        System.out.println(c.calculate(" 31-15 / 2 "));
    }
}
