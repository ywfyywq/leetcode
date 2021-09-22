package com.xyz0751.learn.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 *
 * 难度 中等
 *
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 8
 *
 * @author YY
 */
public class GenerateTrees {
    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> treeNodeList = new ArrayList<>();
        if (n==0) {
            return treeNodeList;
        }


        return generateBSTree(1, n);
    }

    public static List<TreeNode> generateBSTree(int start, int end) {
        List<TreeNode> treeNodeList = new ArrayList<>();
        if (start > end) {
            treeNodeList.add(null);
            return treeNodeList;
        }

        for (int i=start; i<=end; i++) {
            List<TreeNode> leftTree = generateBSTree(start, i-1);
            List<TreeNode> rightTree = generateBSTree(i+1, end);
            for (TreeNode l : leftTree) {
                for (TreeNode r : rightTree) {
                    TreeNode root = new TreeNode(i, l, r);
                    treeNodeList.add(root);
                }
            }
        }

        return treeNodeList;
    }

    public static void main(String[] args) {
        System.out.println(generateTrees(3));
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
