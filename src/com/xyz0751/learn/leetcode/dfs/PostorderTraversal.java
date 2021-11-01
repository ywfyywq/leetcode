package com.xyz0751.learn.leetcode.dfs;

import com.xyz0751.learn.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的后序遍历
 *
 * 难度 简单
 *
 * 给定一个二叉树，返回它的 后序 遍历。
 * @author leetcode
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversal(list, root);
        return list;
    }

    private void postorderTraversal(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            postorderTraversal(list, root.left);
        }
        if (root.right != null) {
            postorderTraversal(list, root.right);
        }
        list.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.right = two;
        two.left = three;
        PostorderTraversal algo = new PostorderTraversal();
        algo.postorderTraversal(one);
    }
}
