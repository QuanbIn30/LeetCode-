package lc_5_6;

import common.ListNode;

/**
 * 链表翻转
 * @author superquanbin@gmail.com
 * @date 2020-05-06 11:44
 */
public class lc_206_reverseList {

    // 方法1：双指针迭代
    public ListNode reverseList1(ListNode head){
        // 定义三个ListNode节点类型的变量，记得要赋初值
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while(cur != null){
            // 站在cur的视角的解读：
            // 1）先把我现在的下一个位置叫tmp先占了
            tmp = cur.next;
            // 然后把我以后的下一个位置指向pre（叫pre过来）
            cur.next = pre;
            // 让pre移到我现在的位置（把我现在的位置给pre小老弟）
            pre = cur;
            // 我自己去占原本叫tmp帮忙占坑的位置，tmp可以走了（我去下一个）
            cur = tmp;
        }
        return pre;
    }

    // 方法2：递归
    public ListNode reverseList2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        // 这个递归终止的时候是来到了链表的最后一个节点
        ListNode cur = reverseList2(head.next);
        // 让当前节点的下一个指向自己
        head.next.next = head;
        // 这是为了防止循环指向，所以断开了原链表中当前节点的指向
        head.next = null;
        return cur;
    }

    //方法3：头插法
    public ListNode reverseList3(ListNode head){
        // 定义一个虚拟头节点newHead
        ListNode newHead= new ListNode(-1);
        while(head != null){
            // 每一轮循环都定义一个next节点来把原链表中的next节点占了（先拿着）
            ListNode next = head.next;
            // 然后head自己把下一个节点指向newHead.next
            head.next = newHead.next;
            // 然后newHead和head一起往后移动，newHead来到head节点
            newHead.next = head;
            // head节点则来到之前让next占坑的节点
            head = next;
        }
        // 因为newHead是虚拟头节点，所以要返回newHead.next
        return newHead;
    }
}
