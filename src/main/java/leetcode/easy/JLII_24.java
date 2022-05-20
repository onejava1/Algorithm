package leetcode.easy;


/**
 * 反转链表
 */
public class JLII_24 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode tmp = head;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        if(tmp == head){
            return head;
        }
        ListNode c = tmp;
        while(head != c){
            if(tmp == c){
                // 第一个的插入
                c.next = head;
                head = head.next;
                c.next.next = null;
                tmp = null;
            } else {
                ListNode p = c.next;
                c.next = head;
                head = head.next;
                c.next.next = p;
            }
        }
        return c;
    }
}
