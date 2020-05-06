package lc_5_6;

import common.ListNode;

/**
 * 相交链表
 * @author superquanbin@gmail.com
 * @date 2020-05-06 09:24
 */
public class lc_160_getIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode l1 = headA;
        ListNode l2 = headB;
        // 不用担心没有相交节点的话这个while会陷入死循环，
        // 因为如果不存在交点，那么a + b = b + a，以下实现代码中l1和l2会同时为null，从而退出循环
        while(l1 != l2){
            // 设headA的长度为a + c；headB的长度为b + c，其中c为尾部公共部分长度，可知a + b + c = b + c + a
            // 当访问headA的指针访问到链表尾时，令它从headB的头部开始访问链表B
            // 同样的，当访问headB的指针访问到链表尾时，令它从headA的头部开始访问headA
            // 这样能控制访问headA、headB两个链表的指针能同时访问到交点
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }
}
