package com.xyz0751.learn.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

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
