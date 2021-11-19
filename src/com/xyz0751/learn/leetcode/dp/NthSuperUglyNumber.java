package com.xyz0751.learn.leetcode.dp;

import java.util.Arrays;

/**
*
* @author: yuj
* @date: 2021/11/19 14:53
*/
public class NthSuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n==1) {
            return 1;
        }

        int[] primesIndex = new int[primes.length];
        Arrays.fill(primesIndex, 1);
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i=2; i<=n; i++) {
            dp[i] = dp[primesIndex[0]]*primes[0];
            for (int j=1; j<primesIndex.length; j++) {
                if (dp[i] > dp[primesIndex[j]]*primes[j]) {
                    dp[i] = dp[primesIndex[j]]*primes[j];
                }
            }
            for (int j=0; j<primesIndex.length; j++) {
                if (dp[i] == dp[primesIndex[j]]*primes[j]) {
                    primesIndex[j]++;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NthSuperUglyNumber algo = new NthSuperUglyNumber();
//        System.out.println(algo.nthSuperUglyNumber(12, new int[]{2,7,13,19}));
        System.out.println(algo.nthSuperUglyNumber(1, new int[]{2,3,5}));
    }
}
