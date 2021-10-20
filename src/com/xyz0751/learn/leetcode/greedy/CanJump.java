package com.xyz0751.learn.leetcode.greedy;

/**
 * 55. 跳跃游戏
 *
 * 给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 *
 * 
 *
 * 示例1：
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例2：
 *
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * 
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanJump {
    public boolean canJump2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i=1; i<nums.length; i++) {
            for (int j=0; j<i; j++) {
                if (dp[j] == 1 && nums[j] >= (i-j)) {
                    dp[i] = 1;
                    break;
                }
            }

        }

        return dp[dp.length-1] == 1;
    }

    public boolean canJump(int[] nums) {
        if(nums.length == 1) {
            return true;
        }

        int maxIndex = 0;
        for (int i=0; i<nums.length; i++) {
            if (maxIndex < i) {
                break;
            }
            maxIndex = Math.max(maxIndex, nums[i]+i);
        }

        return maxIndex >= nums.length-1;
    }

    public static void main(String[] args) {
        CanJump cj = new CanJump();
        System.out.println(cj.canJump(new int[] {2,3,1,1,4}));
        System.out.println(cj.canJump(new int[] {3,2,1,0,4}));
        System.out.println(cj.canJump(new int[] {2,0,0}));
    }
}
