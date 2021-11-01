package com.xyz0751.learn.leetcode.dfs;

import com.xyz0751.learn.leetcode.common.TreeNode;

/**
 * 98. 验证二叉搜索树
 *
 * 难度 中等
 *
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *   
 *
 * 示例 1：
 *
 *
 * 输入：root = [2,1,3]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 *   
 *
 * 提示：
 *
 * 树中节点数目范围在[1, 104] 内
 * -231 <= Node.val <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null && root.left.val >= root.val) {
            return false;
        }

        if (!isValidBSTLeft(root.val, root.left)) {
            return false;
        }

        if (root.right != null && root.right.val <= root.val) {
            return false;
        }

        if (!isValidBSTRight(root.val, root.right)) {
            return false;
        }

        return true;
    }

    private boolean isValidBSTLeft(int maxVal, TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null && (root.left.val >= root.val || root.left.val >= maxVal)) {
            return false;
        }

        if (!isValidBSTLeft(Math.max(maxVal, root.val), root.left)) {
            return false;
        }

        if (root.right != null && (root.right.val <= root.val || root.right.val >= maxVal)) {
            return false;
        }

        if (!isValidBSTRight(Math.max(maxVal, root.val), root.right)) {
            return false;
        }

        return true;
    }

    private boolean isValidBSTRight(int minVal, TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null && (root.left.val >= root.val || root.left.val <= minVal)) {
            return false;
        }

        if (!isValidBSTLeft(Math.min(minVal,root.val), root.left)) {
            return false;
        }

        if (root.right != null && (root.right.val <= root.val || root.right.val <= minVal)) {
            return false;
        }

        if (!isValidBSTRight(Math.min(minVal,root.val), root.right)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(50);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(55);
        node1.left = node2;
        node1.right  = node3;

        TreeNode node4 = new TreeNode(100);
        TreeNode node5 = new TreeNode(75);
        TreeNode node6 = new TreeNode(110);
        node4.left = node5;
        node4.right  = node6;

        TreeNode node7 = new TreeNode(130);
        TreeNode node8 = new TreeNode(119);
        TreeNode node9 = new TreeNode(135);
        node7.left = node8;
        node7.right  = node9;

        TreeNode node10 = new TreeNode(160);
        TreeNode node11 = new TreeNode(150);
        TreeNode node12 = new TreeNode(200);
        node10.left = node11;
        node10.right  = node12;

        TreeNode node13 = new TreeNode(70);
        node13.left = node1;
        node13.right = node4;

        TreeNode node14 = new TreeNode(140);
        node14.left = node7;
        node14.right = node10;

        TreeNode node15 = new TreeNode(120);
        node15.left = node13;
        node15.right = node14;

        IsValidBST algo = new IsValidBST();
        System.out.println(algo.isValidBST(node15));
    }

}
