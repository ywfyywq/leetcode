package com.xyz0751.learn.leetcode.dfs;

import com.xyz0751.learn.leetcode.common.TreeNode;

/**
 * 112. 路径总和
 *
 * 难度 简单
 *
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 * 示例 3：
 *
 * 输入：root = [1,2], targetSum = 0
 * 输出：false
 *  
 *
 * 提示：
 *
 * 树中节点的数目在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        }

        return hasPathSum(root, root.val, targetSum);
    }


    public boolean hasPathSum(TreeNode root, int current, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left != null) {
            if (current + root.left.val == targetSum && root.left.left == null && root.left.right == null) {
                return true;
            } else if (hasPathSum(root.left, current + root.left.val, targetSum)) {
                return true;
            }
        }

        if (root.right != null) {
            if (current + root.right.val == targetSum && root.right.left == null && root.right.right == null) {
                return true;
            } else if (hasPathSum(root.right, current + root.right.val, targetSum)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(-2);
        TreeNode node2 = new TreeNode(-3);
        node1.right = node2;

//        TreeNode node1 = new TreeNode(5);
//        TreeNode node2 = new TreeNode(4);
//        TreeNode node3 = new TreeNode(8);
//        TreeNode node4 = new TreeNode(11);
//        TreeNode node5 = new TreeNode(7);
//        TreeNode node6 = new TreeNode(3);
//        TreeNode node7 = new TreeNode(8);
//        TreeNode node8 = new TreeNode(13);
//        TreeNode node9 = new TreeNode(4);
//        TreeNode node10 = new TreeNode(1);
//        node9.right = node10;
//        node7.left = node8;
//        node7.right = node9;
//
//        node4.left = node5;
//        node4.right = node6;
//
//        node3.left = node8;
//        node3.right = node9;
//
//        node2.left = node4;
//
//        node1.left = node2;
//        node1.right = node3;

        HasPathSum algo = new HasPathSum();
//        System.out.println(algo.hasPathSum(node1, 22));;
        System.out.println(algo.hasPathSum(node1, -5));;

    }
}
