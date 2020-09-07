package lc_6_23;

import java.util.LinkedList;

/**
 * @author superquanbin@gmail.com
 * @date 2020-06-23 11:11
 */
public class lc_jz_09_CQueue {

    LinkedList<Integer> A, B;

    public lc_jz_09_CQueue(){
        A = new LinkedList<Integer>();
        B = new LinkedList<Integer>();
    }

    public void appendTail(int value){
        A.addLast(value);
    }

    public int deleteHead(){
        if(!B.isEmpty()){
            return B.removeLast();
        }
        if(A.isEmpty()){
            return -1;
        }
        while(!A.isEmpty()){
            B.addLast(A.removeLast());
        }
        return B.removeLast();
    }
}
