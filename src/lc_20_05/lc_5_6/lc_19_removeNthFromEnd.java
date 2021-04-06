package lc_20_05.lc_5_6;

import common.ListNode;

/**
 * 删除链表中倒数第n个节点
 * @author superquanbin@gmail.com
 * @date 2020-05-06 22:20
 */
public class lc_19_removeNthFromEnd {

    // 解法1：双指针
    public static ListNode removeNthFromEnd(ListNode head, int n){

        ListNode fast = head;

        // 这相当于 fast 指针走到了包括指向的 head 在内往后的第 n+1 个节点
        while(n-- > 0){
            fast = fast.next;
        }

        // 此时fast如果等于空的话，说明删除的是链表正着数(shú)的第一元素,也就是倒数第n个元素，同时也就是head
        if(fast == null)
            return head.next;

        // 然后slow出场，由fast带着走，这两个指针指向的元素中间总是会隔着n-1个数，不管链表多长，一直走就是了
        // 所以当fast.next等于空的时候，是fast来到了最后一个节点
        // 那么此时slow指针其实是指向倒数第n+1个节点的，
        // 所以此时让slow.next指向slow.next.next就可以跨过倒数第n个节点了，于是就相当于删除了倒数第n个节点
        ListNode slow = head;
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(7);

        ListNode res = removeNthFromEnd(l1, 5);
        System.out.println(res);
    }
}
