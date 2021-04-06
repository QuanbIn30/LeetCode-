package lc_20_04.lc_4_16;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断链表是否存在环
 *
 * @author superquanbin@gmail.com
 * @date 2020-04-16 17:45
 */
public class hasCycle {

    // 方法1：
    // 双指针
    public static boolean hasCycle1(ListNode head) {

        if (head == null)
            return false;

        ListNode l1 = head;
        ListNode l2 = head.next;

        while (l1 != null && l2 != null && l2.next != null) {
            if (l1 == l2) {
                return true;
            }
            l1 = l1.next;
            l2 = l2.next.next;
        }
        return false;
    }

    // 方法2：
    // 哈希表
    public static boolean hasCycle2(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(4);
        n1.next.next.next = new ListNode(6);
        n1.next.next.next.next = n1.next.next;
        //System.out.println(hasCycle1(n1));
        System.out.println(hasCycle2(n1));
    }
}
