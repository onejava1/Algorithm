package leetcode.medium;

public class L_2 {
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode a =new ListNode();
      ListNode tmp = new ListNode();
      a.next = tmp;
      int c = 0;
      while (l1 != null && l2 != null){
          int t = (c + l1.val + l2.val) % 10;
          ListNode node = new ListNode(t);
          c = (c + l1.val + l2.val) / 10;
          tmp.next = node;
          tmp = node;
          l1 = l1.next;
          l2 = l2.next;
      }

      while (l1 != null){
          int t = (c + l1.val) % 10;
          ListNode node = new ListNode(t);
          c = (c + l1.val) / 10;
          tmp.next = node;
          tmp = node;
          l1 = l1.next;
      }

      while (l2 != null){
          int t = (c + l2.val) % 10;
          ListNode node = new ListNode(t);
          c = (c + l2.val) / 10;
          tmp.next = node;
          tmp = node;
          l2 = l2.next;
      }
      if (c == 0){

      }else {
          ListNode node = new ListNode(c);
          tmp.next = node;
      }
      return a.next.next;
  }

}
