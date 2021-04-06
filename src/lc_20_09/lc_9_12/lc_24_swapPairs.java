package lc_20_09.lc_9_12;

import common.ListNode;

/**
 * 两两交换链表中的节点
 * @author MHLEVEL
 * @date 2020-09-12 09:36
 */
public class lc_24_swapPairs {

    // 解法1：递归
    public ListNode swapPairs (ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode rest = head.next.next;
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = swapPairs(rest);
        return newHead;
    }

    /*
    // 解法2：利用栈的先进后出特性
    public static ListNode swapPairs2 (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = new ListNode(-1);
        while(head != null && head.next != null) {
            Stack<ListNode> stack = new Stack<>();
            stack.push(head);
            stack.push(head.next);
            pre.next = stack.pop();
            pre.next.next = stack.pop();
            pre = pre.next.next;
        }
        return head;
    }
     */

    // 解法2：非递归解法
    class Solution {
        public ListNode swapPairs(ListNode head) {

            ListNode pre = new ListNode(0);
            pre.next = head;
            ListNode temp = pre;

            while(temp.next != null && temp.next.next != null) {
                ListNode start = temp.next;
                ListNode end = temp.next.next;
                temp.next = end;
                start.next = end.next;
                end.next = start;
                temp = start;
            }
            return pre.next;
        }
    }
}
