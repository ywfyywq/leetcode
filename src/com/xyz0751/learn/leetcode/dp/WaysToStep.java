package com.xyz0751.learn.leetcode.dp;

public class WaysToStep {
    public static int waysToStep(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        }

        long step1 = 1;
        long step2 = 2;
        long step3 = 4;
        long temp = 0;
        for (int i=3; i<n; i++) {
            temp = (step1 + step2 + step3);
            while(temp > 1000000007) {
                temp -= 1000000007;
            }
            step1 = step2;
            step2 = step3;
            step3 = temp;
        }
        return (int)step3;
    }

    public static void main(String[] args) {
//        System.out.println(waysToStep(1));
//        System.out.println(waysToStep(2));
        System.out.println(waysToStep(4));
        System.out.println(waysToStep(76));
    }
}
