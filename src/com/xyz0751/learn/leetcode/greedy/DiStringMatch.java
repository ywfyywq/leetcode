package com.xyz0751.learn.leetcode.greedy;

import com.xyz0751.learn.leetcode.utils.ArrayUtils;

/**
 * 942. 增减字符串匹配
 *
 * 难度 简单
 *
 * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
 *
 * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
 *
 * 如果 S[i] == "I"，那么 A[i] < A[i+1]
 * 如果 S[i] == "D"，那么 A[i] > A[i+1]
 *  
 *
 * 示例 1：
 *
 * 输入："IDID"
 * 输出：[0,4,1,3,2]
 * 示例 2：
 *
 * 输入："III"
 * 输出：[0,1,2,3]
 * 示例 3：
 *
 * 输入："DDI"
 * 输出：[3,2,0,1]
 *  
 *
 * 提示：
 *
 * 1 <= S.length <= 10000
 * S 只包含字符 "I" 或 "D"。
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-string-match
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DiStringMatch {
    public int[] diStringMatch(String s) {
        int min = 0;
        int max = s.length();

        int[] a = new int[s.length()+1];
        for (int i=0; i<s.length(); i++) {
            a[i] = s.charAt(i) == 'I' ? min++ : max--;
        }

        a[s.length()] = min;
        return a;
    }

    public static void main(String[] args) {
        DiStringMatch dsm = new DiStringMatch();
        ArrayUtils.print(dsm.diStringMatch("IDID"));
        ArrayUtils.print(dsm.diStringMatch("III"));
        ArrayUtils.print(dsm.diStringMatch("DDI"));
    }
}
