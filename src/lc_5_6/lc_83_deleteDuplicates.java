package lc_5_6;

import common.ListNode;

/**
 * @author superquanbin@gmail.com
 * @date 2020-05-06 21:51
 */
public class lc_83_deleteDuplicates {


    public ListNode deleteDuplicates1(ListNode head){
        // 这个 if() + 后面那个递归 就直接将当前节点拉到了最后一个链表的最后一个
        if(head == null || head.next == null) return head;
        head.next = deleteDuplicates1(head.next);
        // 然后从后往前return的过程就是我（从后往前的视角）挨个的看我来到的这个节点和我现在第一个节点值一样吗
        // 一样的话就撇开他，你走开，然后继续利用return的过程带着已经确定没有重复节点的一群小老弟从后往前走
        return head.val == head.next.val ? head.next : head;
    }
}
