package lc_9_7;

import common.ListNode;

/**
 * 链表的中间节点
 * @author superquanbin@gmail.com
 * @date 2020-09-07 09:39
 */
public class lc_876_middleNode {

    // 解法1：双指针
    public ListNode middleNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
