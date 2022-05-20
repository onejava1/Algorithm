package leetcode.medium;

public class JLII_21 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode fast = head;
        ListNode tmp = head;
        ListNode pre = head;
        while(n != 0){
            fast = fast.next;
            n--;
        }
        if(fast == null){
            return head;
        }
        while(fast != null){
            pre = tmp;
            tmp = tmp.next;
            fast = fast.next;
        }
        pre.next = tmp.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(2);
//        l1.next = l2;
        JLII_21 l = new JLII_21();
        l.removeNthFromEnd(l1, 1);

    }

}
