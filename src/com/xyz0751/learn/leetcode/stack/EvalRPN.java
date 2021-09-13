package com.xyz0751.learn.leetcode.stack;

import java.util.Stack;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                Integer num1 = Integer.valueOf(stack.pop());
                Integer num2 = Integer.valueOf(stack.pop());
                Integer num3 = num1 + num2;
                stack.push(num3+"");
            } else if ("-".equals(token)) {
                Integer num1 = Integer.valueOf(stack.pop());
                Integer num2 = Integer.valueOf(stack.pop());
                Integer num3 = num2 - num1;
                stack.push(num3+"");
            } else if ("*".equals(token)) {
                Integer num1 = Integer.valueOf(stack.pop());
                Integer num2 = Integer.valueOf(stack.pop());
                Integer num3 = num1 * num2;
                stack.push(num3+"");
            } else if ("/".equals(token)) {
                Integer num1 = Integer.valueOf(stack.pop());
                Integer num2 = Integer.valueOf(stack.pop());
                Integer num3 = num2 / num1;
                stack.push(num3+"");
            } else {
                stack.push(token);
            }
        }

        return Integer.valueOf(stack.pop());
    }

    public static void main(String[] args) {
        EvalRPN evalRPN = new EvalRPN();
        System.out.println(evalRPN.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }

}
