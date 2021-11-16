package com.xyz0751.learn.leetcode.dc;

import com.xyz0751.learn.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 *
 * 难度 中等
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @author ：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuildTree2 {
    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] inorder, int[] postorder, int inorder_left, int inorder_right, int postorder_left, int postorder_right) {
        if (inorder_left > inorder_right) {
            return null;
        }

        // 后序遍历中的最后一个节点就是根节点
        int postorder_root = postorder_right;
        // 在前序遍历中定位根节点
        int inorder_root = indexMap.get(postorder[postorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(postorder[postorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 中序遍历中「从 左边界 开始到 根节点定位-1 结束就对应了后序遍历中「从 左边界 开始到 size_left_subtree个元素」的元素
        root.left = myBuildTree(inorder, postorder, inorder_left, inorder_root - 1, postorder_left, postorder_left + size_left_subtree-1);
        // 递归地构造右子树，并连接到根节点
        // 中序遍历中「从 根节点定位+1 开始到 右边界」的元素就对应了后序遍历中「左边界+1+左子树节点数目 到 右边界-1」的元素
        root.right = myBuildTree(inorder, postorder, inorder_root + 1, inorder_right, postorder_left + size_left_subtree, postorder_right-1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(inorder, postorder, 0, n - 1, 0, n - 1);
    }

    public static void main(String[] args) {
        BuildTree2 algo = new BuildTree2();
        System.out.println(algo.buildTree(new int[] {9,3,15,20,7}, new int[]{9,15,7,20,3}));
    }
}
