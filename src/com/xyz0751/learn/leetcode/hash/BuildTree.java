package com.xyz0751.learn.leetcode.hash;

import com.xyz0751.learn.leetcode.common.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * 难度 中等
 *
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 *
 *  
 *
 * 示例 1:
 *
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * 示例 2:
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *  
 *
 * 提示:
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均无重复元素
 * inorder 均出现在 preorder
 * preorder 保证为二叉树的前序遍历序列
 * inorder 保证为二叉树的中序遍历序列
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> preorderIndex = new HashMap<>();
        for (int i=0; i<preorder.length; i++) {
            preorderIndex.put(preorder[i], i);
        }

        Map<Integer, Integer> inorderIndex = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length-1,
                preorderIndex, inorder, 0, inorder.length-1, inorderIndex);
    }

    public TreeNode buildTree(int[] preorder,
                              int preorderStart,
                              int preorderEnd,
                              Map<Integer, Integer> preorderIndex,
                              int[] inorder,
                              int inorderStart,
                              int inorderEnd,
                              Map<Integer, Integer> inorderIndex) {
        if (preorderStart > preorderEnd) {
            return null;
        } else if (preorderStart == preorderEnd) {
            return new TreeNode(preorder[preorderStart]);
        }

        // 根节点在中序遍历中的位置
        Integer inorderRootIndex = inorderIndex.get(preorder[preorderStart]);


        TreeNode root = new TreeNode(preorder[preorderStart]);
        TreeNode left = null;
        TreeNode right = null;
        if (inorderRootIndex == inorderStart) {
            // 没有左子树
            right = buildTree(preorder, preorderStart + 1, preorderEnd, preorderIndex,
                    inorder, inorderRootIndex + 1, inorderEnd, inorderIndex);
        } else if (inorderRootIndex == inorderEnd) {
            // 没有右子树
            left = buildTree(preorder, preorderStart + 1, preorderEnd, preorderIndex,
                    inorder, inorderStart, inorderRootIndex - 1, inorderIndex);
        } else {
            // 左子树右节点在先序中的位置
            int leftIndex = preorderStart + 1;
            int rightIndex = leftIndex + (inorderRootIndex-1-inorderStart);

            left = buildTree(preorder, leftIndex, rightIndex, preorderIndex,
                    inorder, inorderStart, inorderRootIndex - 1, inorderIndex);
            right = buildTree(preorder, rightIndex + 1, preorderEnd, preorderIndex,
                    inorder, inorderRootIndex + 1, inorderEnd, inorderIndex);
        }
        root.left = left;
        root.right = right;

        return root;
    }

    public static void main(String[] args) {
        BuildTree algo = new BuildTree();
//        System.out.println(algo.buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20}));
//        System.out.println(algo.buildTree(new int[] {1,2,3}, new int[] {2,3,1}));
//        System.out.println(algo.buildTree(new int[] {3,2,1,4}, new int[] {1,2,3,4}));
        System.out.println(algo.buildTree(new int[] {7,-10,-4,3,-1,2,-8,11}, new int[] {-4,-10,3,-1,7,11,-8,2}));
    }
}
