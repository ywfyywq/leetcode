package com.xyz0751.learn.leetcode.stack;

import java.util.Stack;

public class BackspaceCompare {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> ss = new Stack<>();
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!ss.isEmpty()) {
                    ss.pop();
                }
            } else {
                ss.push(c);
            }
        }

        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(c);
            }
        }

        if (ss.size() != st.size()) {
            return false;
        }

        while (!ss.isEmpty()) {
            if (ss.pop() != st.pop()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BackspaceCompare bc = new BackspaceCompare();
        System.out.println(bc.backspaceCompare("a#c","b"));
    }
}
