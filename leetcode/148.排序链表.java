/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }
    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail) {
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
            slow = slow.next;
        }
        ListNode list1 = sortList(head, slow);
        ListNode list2 = sortList(slow, tail);
        ListNode list = merge(list1, list2);
        return list;
    }
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode node = new ListNode(-1);
        ListNode tmp = node;
        ListNode tmp1 = head1;
        ListNode tmp2 = head2;
        while (tmp1 != null && tmp2 != null) {
            if (tmp1.val < tmp2.val) {
                tmp.next = tmp1;
                tmp1 = tmp1.next;
            } else {
                tmp.next = tmp2;
                tmp2 = tmp2.next;
            }
            tmp = tmp.next;
        }
        if (tmp1 != null) {
            tmp.next = tmp1;
        }
        if (tmp2 != null) {
            tmp.next = tmp2;
        }
        return node.next;
    }
}
// @lc code=end

