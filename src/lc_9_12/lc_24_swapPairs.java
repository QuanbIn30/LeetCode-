package lc_9_12;

import common.ListNode;

/**
 * 两两交换链表中的节点
 * @author MHLEVEL
 * @date 2020-09-12 09:36
 */
public class lc_24_swapPairs {

    public ListNode swapPairs (ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode rest = head.next.next;
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = swapPairs(rest);
        return newHead;
    }
}
