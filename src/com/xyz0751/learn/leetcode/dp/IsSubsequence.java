package com.xyz0751.learn.leetcode.dp;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int index = 0;
        for (int i=0; index<s.length() && i<t.length(); i++) {
            if (s.charAt(index) == t.charAt(i)) {
                index++;
            }
        }

        return index == s.length();
    }

    public static boolean isSubsequence2(String s, String t) {
        int index = -1;
        for (int i=0; i<s.length(); i++) {
            if ((index = t.indexOf(s.charAt(i), index+1)) == -1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence2("axc", "ahbgdc"));
    }
}
