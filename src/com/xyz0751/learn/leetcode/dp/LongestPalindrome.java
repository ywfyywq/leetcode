package com.xyz0751.learn.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindrome {
    public static boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        } else if(s.length() == 2) {
            return s.charAt(0) == s.charAt(1);
        }

        int start = 0;
        int end = s.length()-1;
        while (start < end){
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        };
        return true;
    }
    public static String longestPalindrome(String s) {
        if(isPalindrome(s)) {
            return s;
        }

        List<String> palindromeList = new ArrayList<>();
        String maxPalindrome = s.charAt(0)+"";
        palindromeList.add(maxPalindrome);
        for (int i=1; i<s.length(); i++) {
            String prePalindrome = palindromeList.get(i-1);
            char current = s.charAt(i);
            String str1 = "-1";
            String str2 = prePalindrome + current;;
            String str3 = i >=2 ? s.substring(i-2, i+1) : "-1";
            String str4 = s.substring(i-1, i+1);
            if (prePalindrome.length() != i) {
                str1 = s.charAt(i-prePalindrome.length()-1) + prePalindrome + current;
            }

            if (isPalindrome(str1)) {
                palindromeList.add(str1);
            } else if(isPalindrome(str2)) {
                palindromeList.add(str2);
            } else if(isPalindrome(str3)) {
                palindromeList.add(str3);
            } else if(isPalindrome(str4)) {
                palindromeList.add(str4);
            } else {
                palindromeList.add(current+"");
            }

            if(palindromeList.get(i).length() > maxPalindrome.length()) {
                maxPalindrome = palindromeList.get(i);
            }
        }

        return maxPalindrome;
    }

    public static void main(String[] args) {
//        System.out.println(isPalindrome("sss"));
//        System.out.println(isPalindrome("a"));
//        System.out.println(isPalindrome("ab"));
//        System.out.println(isPalindrome("bb"));
//        System.out.println(isPalindrome("ssbcbtcbss"));
//        System.out.println(longestPalindrome("bananas"));
//        System.out.println(longestPalindrome("cbbd"));
//        System.out.println(longestPalindrome("a"));
//        System.out.println(longestPalindrome("ac"));
//        System.out.println(longestPalindrome("ccd"));
        System.out.println(longestPalindrome("321012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210123210012321001232100123210123"));
    }
}
