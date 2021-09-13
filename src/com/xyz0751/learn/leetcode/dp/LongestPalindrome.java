package com.xyz0751.learn.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindrome {
    public static String longestPalindrome2(String s) {
        if (s.length() <= 1) {
            return s;
        }

        if (s.length() <= 3 && s.charAt(0) == s.charAt(s.length()-1)) {
            return s;
        }

        String longestPalindrome = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i=s.length(); i>=0; i--) {
            for (int j=i; j<s.length(); j++) {
                dp[i][j]=(s.charAt(i) == s.charAt(j)) && ((j-i<3) || dp[i+1][j-1]);
                if (dp[i][j] && (longestPalindrome.equals("") || longestPalindrome.length() < j-i+1)) {
                    longestPalindrome = s.substring(i, j+1);
                }
            }
        }

        return longestPalindrome;
    }
    public static String longestPalindrome3(String s) {
        String longestPalindrome = "";
        for (int i=0; i<s.length(); i++) {
            longestPalindrome = maxPalindrome(s, i, i, longestPalindrome);
            longestPalindrome = maxPalindrome(s, i, i+1, longestPalindrome);
        }
        return longestPalindrome;
    }

    public static String maxPalindrome(String s, int i, int j, String res) {
        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (j-i-1 > res.length()) {
            return s.substring(i+1, j);
        }
        return res;
    }

    public static String longestPalindrome4(String s) {
        if(s.length() == 0) {
            return "";
        }
        int left = 0;
        int right = -1;
        int pl = 0;
        int pr = 0;
        while(left < s.length()) {
            while(right+1<s.length() && s.charAt(left) == s.charAt(right+1)) {
                right++;
            }
            while(left>=1 && right<s.length()-1 && s.charAt(left-1) == s.charAt(right+1)) {
                left--;
                right++;
            }

            if(right-left > pr-pl) {
                pl = left;
                pr = right;
            }

            left = (right+left)/2+1;
            right = left;
        }


        return s.substring(pl, pr+1);
    }

    public static String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for(int i=0; i<s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        String newS = sb.toString();
        int[] dp = new int[newS.length()];
        int maxRight = 0;
        int center = 0;
        int maxLen = 1;
        int begin = 0;

        for (int i=0; i<dp.length; i++) {
            if(i<maxRight) {
               dp[i] = (maxRight-i) < dp[(2*center-i)] ? (maxRight-i) : dp[(2*center-i)];
            }

            int left = i - (1+dp[i]);
            int right = i+ (1+dp[i]);
            while(left>=0 && right<newS.length() && newS.charAt(left) == newS.charAt(right)) {
                dp[i]++;
                left--;
                right++;
            };
            if(i+dp[i] > maxRight) {
                maxRight = i+dp[i];
                center = i;
            }
            if(dp[i] > maxLen) {
                maxLen = dp[i];
                begin = (i-maxLen)/2;
            }
        }

        return s.substring(begin, begin+maxLen);
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
        System.out.println(longestPalindrome("ccd"));
        System.out.println(longestPalindrome("321012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210123210012321001232100123210123"));
    }
}
