package leetcode.weekilycompetion;

public class L_6013 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeNodes(ListNode head) {
        ListNode tmp = new ListNode();
        ListNode h = new ListNode();
        tmp.next = h;
        ListNode c = head.next;

        int res = 0;
        while (c != null){
            if (c.val== 0){
                ListNode tc = new ListNode(res);
                h.next = tc;
                h = tc;
                res = 0;
            }
            res += c.val;
            c = c.next;
        }
        return tmp.next.next;
    }
}
