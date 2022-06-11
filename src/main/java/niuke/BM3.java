package niuke;

import java.awt.*;
import java.io.Flushable;

/**
 *
 *
 * @author huang.fei
 * @version 1.0
 * @description 牛客 链表中的节点每K个一组反转
 * @date 2022/6/11 12:55
 **/
public class BM3 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val){
            this.val = val;
        }


    }
    public static ListNode reverseKGroup (ListNode head, int k) {
        if(head == null){
            return null;
        }
        // write code here
        ListNode tmp = head;
        int needStep = k - 1;
        ListNode fast = head;
        while (needStep != 0){
            fast = fast.next;
            if (fast == null){
                return head;
            }
            needStep--;
        }
        ListNode res = fast;
        // 下一段的pre
        ListNode reverse = reverse(null, tmp, fast);
        //
        if(reverse.next == null){
            return res;
        }
        needStep = k - 1;
        for(;;){
            ListNode h = reverse.next;
            ListNode f = h;
            while (needStep != 0){
                f = f.next;
                if(f == null){
                    return res;
                }
                needStep--;
            }
            needStep = k - 1;
            //
            reverse = reverse(reverse, h, f);
            if(reverse.next == null){
                return res;
            }
        }
    }

    // 返回的是前一段的头部
    public static ListNode reverse(ListNode pre, ListNode head, ListNode headTail){
        // 尾插法
        if (pre != null) {
            pre.next = headTail;
        }

        ListNode preTail = head;
        while (head != headTail){
            ListNode tm = head.next;
            ListNode tt = headTail.next;

            headTail.next = head;
            head.next = tt;
            head = tm;
        }
        return preTail;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;


        ListNode listNode = reverseKGroup(l1, 3);
//        ListNode reverse = reverse(null, l1, l5);
        print(listNode);


    }
    private static void print(ListNode l){
        while (l != null){
            System.out.println(l.val);
            l = l.next;
        }
    }



}


