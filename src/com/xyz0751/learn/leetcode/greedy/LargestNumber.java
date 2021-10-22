package com.xyz0751.learn.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 179. 最大数
 *
 * 难度 中等
 *
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 *     
 *
 * 示例 1：
 *
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例    2：
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 *
 * 输入：nums = [10]
 * 输出："10"
 *     
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        String[] numStr = new String[nums.length];
        for (int i=0; i < nums.length; i++) {
            numStr[i] = nums[i]+"";
        }

        Arrays.sort(numStr, (a,b)->{
            if (a.length() == b.length()) {
                return a.compareTo(b);
            } else {
                if (a.startsWith(b) || b.startsWith(a)) {
                    return (a+b).compareTo(b+a);
                } else {
                    return a.compareTo(b);
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        boolean hasNoneZeroElement = false;
        for (int i=numStr.length-1; i>=0; i--) {
            if (!"0".equals(numStr[i]) ) {
                hasNoneZeroElement = true;
            }
            if (hasNoneZeroElement || i==0){
                sb.append(numStr[i]);
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LargestNumber ln = new LargestNumber();
//        System.out.println(ln.largestNumber(new int[] {10,2}));
        System.out.println(ln.largestNumber(new int[] {30,3,30,32,5,9}));
//        System.out.println(ln.largestNumber(new int[] {1}));
//        System.out.println(ln.largestNumber(new int[] {10}));
        System.out.println(ln.largestNumber(new int[] {432,43243}));

        System.out.println(ln.largestNumber(new int[] {1,0,0}));
    }
}
