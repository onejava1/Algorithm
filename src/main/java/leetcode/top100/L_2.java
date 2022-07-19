package leetcode.top100;

/**
 * @author huang.fei
 * @version 1.0
 * @description https://leetcode.cn/problems/add-two-numbers/
 * @date 2022/7/14 21:27
 **/
public class L_2 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resHead = l1;
        int carry = 0;
        ListNode pre = resHead;
        while (l1 != null && l2 != null){
            pre = l1;
            int tmp = l1.val + l2.val + carry;
            l1.val = tmp % 10;
            carry = tmp / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        // 两个一样长度
        if (l1 == null && l2 == null){
            if (carry != 0){
                ListNode tail = new ListNode(carry);
                pre.next = tail;
            }
        }else {
            // l1 更长
            if (l2 == null){
                calculateTheRemainingList(l1, carry);
            }
            if (l1 == null){
                // l2更长
                pre.next = l2;
                calculateTheRemainingList(l2, carry);
            }
        }
        return resHead;
    }

    private void calculateTheRemainingList(ListNode node, int carry){
        ListNode pre = node;
        while (node != null){
            pre = node;
            int tmp = node.val + carry;
            node.val = tmp % 10;
            carry = tmp >= 10 ? 1 : 0;
            node = node.next;
        }
        if (carry != 0){
            pre.next = new ListNode(1);
        }
    }



}
