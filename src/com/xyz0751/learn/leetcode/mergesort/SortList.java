package com.xyz0751.learn.leetcode.mergesort;

import com.xyz0751.learn.leetcode.common.ListNode;

/**
 * 148. 排序链表
 *
 * 难度 中等
 *
 * 给你链表的头结点  head  ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 * 你可以在  O(n  log  n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *   
 *
 * 示例 1：
 *
 *
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 *
 *
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *   
 *
 * 提示：
 *
 * 链表中节点的数目在范围  [0, 5 * 104]  内
 * -105  <= Node.val <= 105
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode mergeList = mergeList(list1, list2);
        return mergeList;
    }

    private ListNode mergeList(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode tempHead = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tempHead.next = list1;
                list1 = list1.next;
            } else {
                tempHead.next = list2;
                list2 = list2.next;
            }
            tempHead = tempHead.next;
        }

        if (list1 != null) {
            tempHead.next = list1;
        }
        if (list2 != null) {
            tempHead.next = list2;
        }
        head = head.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        SortList algo = new SortList();
        System.out.println(algo.sortList(n1));
    }
}
