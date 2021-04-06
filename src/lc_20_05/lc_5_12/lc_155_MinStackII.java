package lc_20_05.lc_5_12;

/**
 * 实现最小值栈
 * 这里的实现没有利用java提供的stack而是使用链表来实现
 * @author superquanbin@gmail.com
 * @date 2020-05-12 08:59
 */
public class lc_155_MinStackII {
    class Node{
        int value;
        int min;
        Node next;

        Node (int x, int min){
            this.value = x;
            this.min = min;
            next = null;
        }
    }

    Node head;

    // 每次加入的节点放到头部
    public void push(int x){
        if(head == null){
            head = new Node(x,x);
        }else{
            // 当前值和头节点的最小值较小的作为当前的min
            Node n = new Node(x, Math.min(x, head.min));
            n.next = head;
            head = n;
        }
    }

    public void pop(){
        if(head != null){
            head = head.next;
        }
    }

    public int top(){
        if(head != null) {
            return head.value;
        }
        return -1;
    }

    public int getmin(){
        if(head != null) {
            return head.min;
        }
        return -1;
    }
}
