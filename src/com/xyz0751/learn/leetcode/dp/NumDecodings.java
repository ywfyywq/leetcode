package com.xyz0751.learn.leetcode.dp;

public class NumDecodings {
    public static int numDecodings(String s) {
        if (s.length() == 0 || s.startsWith("0")) {
            return 0;
        }

        if (s.length() == 1) {
            if (s.compareTo("1")>=0 && s.compareTo("9")<=0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (s.charAt(0) <'1' || s.charAt(0) > '9') {
                return 0;
            }
        }

        int[] dp1 = new int[s.length()];
        int[] dp2 = new int[s.length()];

        dp1[0] = 1;
        dp2[0] = 0;
        for (int i=1; i<s.length(); i++) {
            char preChar = s.charAt(i-1);
            char currentChar = s.charAt(i);
            if (currentChar >='1' && currentChar <= '9') {
                dp1[i] = dp1[i-1] + dp2[i-1];
            }

            if (dp1[i-1] > 0) {
                if (currentChar == '0' && (preChar == '1' || preChar == '2')) {
                    dp1[i] = 0;
                    dp2[i] = dp1[i-1];
                } else if(currentChar>='1') {
                    if (currentChar<='6') {
                        if (preChar == '1' || preChar == '2') {
                            dp2[i] = dp1[i-1];
                        }
                    } else if (currentChar>'6' && currentChar <='9') {
                        if (preChar == '1') {
                            dp2[i] = dp1[i-1];
                        }
                    }
                }
            }

            if (dp1[i] == 0 && dp2[i] == 0) {
                return 0;
            }
        }

        return dp1[s.length()-1] + dp2[s.length()-1];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("226"));
        System.out.println(numDecodings("22630"));
        System.out.println(numDecodings("06"));
    }
}
