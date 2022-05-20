package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;

public class JL_35 {
    class Node {
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    // 最容易想到的最垃圾的办法 采用hashMap 但是内存消耗过大
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        var nodeMap = new HashMap<Node, Node>();
        Node tmp = head;
        var virtual = new Node(1);
        while (tmp != null){
            var a = new Node(tmp.val);
            nodeMap.put(tmp, a);
            virtual.next = a;
            virtual = a;
            tmp = tmp.next;
        }
        var o = head;
        while (head != null){
            if (head.random != null){
                var virtualnode = nodeMap.get(head.random);
                var neednode = nodeMap.get(head);
                neednode.random = virtualnode;
            }
            head = head.next;
        }
        return nodeMap.get(o);
    }

    // 拆分链表 a->b->c a->a'->b->b'->c->c'
    // 这样a的random指针的下一个也是 a'的random的指针
    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = node.next;
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }
        Node headNew = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
            return headNew;
        }


    public static void main(String[] args) {

    }
}
