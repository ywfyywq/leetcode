package com.xyz0751.learn.leetcode.dc;

import com.xyz0751.learn.leetcode.common.ListNode;
import com.xyz0751.learn.leetcode.common.TreeNode;

/**
 * 109. 有序链表转换二叉搜索树
 * 难度 中等
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode preMid = head;
        ListNode mid = preMid == null || preMid.next == null ? null : preMid.next;
        ListNode last = mid == null ? null : mid.next;
        while (preMid != null && mid != null && last != null && last.next != null) {
            preMid = preMid.next;
            mid = mid.next;
            last = last.next.next;
        }
        TreeNode root = new TreeNode(mid.val);
        preMid.next = null;
        TreeNode left = sortedListToBST(head);
        TreeNode right = sortedListToBST(mid == null ? null : mid.next);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);

//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        SortedListToBST algo = new SortedListToBST();
        System.out.println(algo.sortedListToBST(node1));
    }
}
