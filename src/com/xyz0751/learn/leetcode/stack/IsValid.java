package com.xyz0751.learn.leetcode.stack;

import java.util.LinkedList;

public class IsValid {
    public boolean isValid(String s) {
        if (!(s.length() % 2 == 0)) {
            return false;
        }

        LinkedList<Character> list = new LinkedList();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (list.isEmpty() || list.removeLast() != '(') {
                    return false;
                }
            } else if (s.charAt(i) == ']') {
                if (list.isEmpty() || list.removeLast() != '[') {
                    return false;
                }
            } else if (s.charAt(i) == '}') {
                if (list.isEmpty() || list.removeLast() != '{') {
                    return false;
                }
            } else {
                list.add(s.charAt(i));
            }
        }

         return list.isEmpty();
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        System.out.println(isValid.isValid("([)]"));
    }
}
