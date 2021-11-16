package com.xyz0751.learn.leetcode.dc;

import com.xyz0751.learn.leetcode.common.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 * 难度 简单
 *
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 *
 * 示例 2：
 *
 *
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 按 严格递增 顺序排列
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start == end) {
            return new TreeNode(nums[start]);
        }

        if (end - start == 1) {
            TreeNode high = new TreeNode(nums[end]);
            TreeNode low = new TreeNode(nums[start]);
            high.left = low;
            return high;
        }

        int mid = start + (end - start + 1)/2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = sortedArrayToBST(nums, start, mid-1);
        TreeNode right = sortedArrayToBST(nums, mid+1, end);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        SortedArrayToBST algo = new SortedArrayToBST();
//        System.out.println(algo.sortedArrayToBST(new int[] {-10,-3,0,5,9}));
        System.out.println(algo.sortedArrayToBST(new int[] {0,1,2,3,4,5}));
    }
}
