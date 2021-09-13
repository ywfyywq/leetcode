package com.xyz0751.learn.leetcode.stack;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<Character> stack = new Stack<>();
        int dotCount = 0;
        boolean dir = false;
        for (char c : path.toCharArray()) {
            if (c == '/') {
                if (!stack.isEmpty() && stack.peek() == '/') {
                    continue;
                } else if (dotCount == 1) {
                    stack.pop();
                } else if (dotCount == 2) {
                    up(stack);
                    stack.push(c);
                    dir = true;
                } else {
                    stack.push(c);
                    dir = true;
                }
                dotCount = 0;
            } else if(c == '.') {
                stack.push(c);
                if (dir) {
                    dotCount++;
                }
            } else {
                stack.push(c);
                dotCount = 0;
                dir = false;
            }
        }

        if (dotCount == 1) {
            stack.pop();
        } else  if (dotCount == 2) {
            up(stack);
        }

        if (stack.isEmpty()) {
            stack.push('/');
        } else  if (stack.peek() == '/' && stack.size() > 1) {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    private void up(Stack<Character> stack) {
        int count = 0;
        while (!stack.isEmpty() && count <= 1) {
            if (stack.pop() == '/') {
                count++;
            }
        }
    }

    public static void main(String[] args) {
        SimplifyPath sp = new SimplifyPath();
        System.out.println(sp.simplifyPath("/hello././world"));
    }
}
