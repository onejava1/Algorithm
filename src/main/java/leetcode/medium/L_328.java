package leetcode.medium;

public class L_328 {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head == null ? null : head;
        }
        // 直接维护两个奇偶链表的投指针
        ListNode oddNumber = head;
        ListNode even = head.next;

        ListNode head1 = oddNumber;
        ListNode head2 = even;

        for (;;){
            // 保证两个端点都到达了尾巴端点才推出
            if (head1.next == null || head2.next == null){
                break;
            }
            head1.next = head2.next;
            head1 = head1.next;
            if (head1.next == null){
                head2.next = null;
                continue;
            }else {
                head2.next = head1.next;
                head2 = head2.next;
            }
        }
        head1.next = even;
        return oddNumber;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        L_328 l_328 = new L_328();
        l_328.oddEvenList(node1);
    }
}
