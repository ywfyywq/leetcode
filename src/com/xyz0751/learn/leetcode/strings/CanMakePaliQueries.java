package com.xyz0751.learn.leetcode.strings;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1177. 构建回文串检测
 *
 * 难度 中等
 *
 * 给你一个字符串 s，请你对 s 的子串进行检测。
 *
 * 每次检测，待检子串都可以表示为 queries[i] = [left, right, k]。我们可以 重新排列 子串 s[left], ..., s[right]，并从中选择 最多 k 项替换成任何小写英文字母。 
 *
 * 如果在上述检测过程中，子串可以变成回文形式的字符串，那么检测结果为 true，否则结果为 false。
 *
 * 返回答案数组 answer[]，其中 answer[i] 是第 i 个待检子串 queries[i] 的检测结果。
 *
 * 注意：在替换时，子串中的每个字母都必须作为 独立的 项进行计数，也就是说，如果 s[left..right] = "aaa" 且 k = 2，我们只能替换其中的两个字母。（另外，任何检测都不会修改原始字符串 s，可以认为每次检测都是独立的）
 *
 *  
 *
 * 示例：
 *
 * 输入：s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
 * 输出：[true,false,false,true,true]
 * 解释：
 * queries[0] : 子串 = "d"，回文。
 * queries[1] : 子串 = "bc"，不是回文。
 * queries[2] : 子串 = "abcd"，只替换 1 个字符是变不成回文串的。
 * queries[3] : 子串 = "abcd"，可以变成回文的 "abba"。 也可以变成 "baab"，先重新排序变成 "bacd"，然后把 "cd" 替换为 "ab"。
 * queries[4] : 子串 = "abcda"，可以变成回文的 "abcba"。
 *  
 *
 * 提示：
 *
 * 1 <= s.length, queries.length <= 10^5
 * 0 <= queries[i][0] <= queries[i][1] < s.length
 * 0 <= queries[i][2] <= s.length
 * s 中只有小写英文字母
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-make-palindrome-from-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanMakePaliQueries {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        int[][] dp = new int[s.length()+1][26];
        dp[1][s.charAt(0)-'a']++;
        for (int i=1; i<s.length(); i++) {
//            dp[i+1] = Arrays.copyOf(dp[i], 26);
            for (int j=0; j<dp[i].length; j++) {
                dp[i+1][j] = dp[i][j];
            }
            dp[i+1][s.charAt(i)-'a'] = dp[i][s.charAt(i) - 'a'] + 1;
        }

        for (int i=0; i<queries.length; i++) {
            ans.add(isPalindrome(dp[queries[i][0]], dp[queries[i][1]+1], queries[i][2]));
        }
        return ans;
    }

    private boolean isPalindrome(int[] nums1, int[] nums2, int maxChangeNum) {
        int count = 0;
        maxChangeNum *= 2;
        for (int i=0; i<nums2.length; i++) {
            if ( (nums2[i] - nums1[i]) % 2 == 1) {
                maxChangeNum--;
            }
            count += (nums2[i]-nums1[i]);
        }
        if (count % 2 == 1) {
            maxChangeNum++;
        }

        return maxChangeNum >= 0;
    }

    private boolean isPalindrome2(String s, int maxChangeNum) {

        if (s.length() == 1) {
            return true;
        }
        int[] nums = new int[26];

        maxChangeNum *= 2;
        if (s.length() % 2 == 1) {
            maxChangeNum++;
        }

        for (int i=0; i<s.length(); i++) {
            int num = ++nums[s.charAt(i) - 'a'];
            if (num % 2 == 1) {
                maxChangeNum--;
            } else {
                maxChangeNum++;
            }
        }

        return maxChangeNum>=0;
    }

    public static void main(String[] args) {
        CanMakePaliQueries algo = new CanMakePaliQueries();
        System.out.println(algo.canMakePaliQueries("abcda", new int[][]{ {3,3,0}, {1,2,0}, {0,3,1}, {0,3,2}, {0,4,1}}));
        System.out.println(algo.canMakePaliQueries("hunu", new int[][]{ {0,3,1}}));
    }
}
