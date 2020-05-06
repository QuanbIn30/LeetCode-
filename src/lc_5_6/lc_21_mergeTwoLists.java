package lc_5_6;

import common.ListNode;

/**
 * 归并两个有序链表
 * @author superquanbin@gmail.com
 * @date 2020-05-06 19:14
 */
public class lc_21_mergeTwoLists {

    /*
    // 这是我自己写的，思路是用双指针，从两个链表的头开始挨个比较节点值的大小
    // 把值较小的存进新的链表中，然后指针往后移动，如果两个值相等则一起存进链表中，并都往后走一步
    // 然后返回新链表
    // ！！！但是这种方法好像超时了，目测应该是有死循环，暂时没找到问题原因
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode newList = new ListNode(-1);
        while(n1 != null && n2 != null){
            if(n1.val < n2.val){
                newList.next = n1;
                n1 = n1.next;
                newList = newList.next;
            }else if(n1.val > n2.val){
                newList.next = n2;
                n2 = n2.next;
                newList = newList.next;
            }else{
                newList.next = n1;
                newList.next.next = n2;
                n1 = n1.next;
                n2 = n2.next;
                newList = newList.next.next;
            }
        }
        while(n1 != null && n2 == null){
            newList.next = n1;
            n1 = n1.next;
            newList = newList.next;
        }
        while(n1 == null && n2 != null){
            newList.next = n2;
            n2 = n2.next;
            newList = newList.next;
        }

        return newList.next;
    }

     */

    // 方法1：递归解法
    // 因为两个链表都是有序的，这个算法的思路其实是把两个链表中值最大的节点挤到了最后一个，然后一次往前面小的节点挂
    // 因为相对当前这层递归来说，他们就是从小的节点来的
    // 如果是对于当前节点来说，后面的递归过程我不管的话，就是要把后面递归过程的结果挂在我这一层值比较小的那个节点上
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }

    // 方法2：迭代解法
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 == null ? l2 : l1);
        // 这里返回tail.next就错了，尾插法的精髓就在这，tail就是一直往链表尾在插新节点，而dummyHead是没有动的
        // return tail.next;
        // 所以这里应该返回DummyHead.next
        return dummyHead.next;
    }


}
