package leetcode.medium;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class JL_36 {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    // 中序遍历时间复杂度太高
    public Node treeToDoublyList(Node root) {
        if (root == null){
            return null;
        }
        Deque<Node> stack = new ArrayDeque<Node>();
        List<Node> queue = new ArrayList<Node>();
        // 将搜索二叉树的节点从小打到放入queue
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.addFirst(root);
                root = root.left;
            }
            Node node = stack.removeFirst();
            if (node.right != null){
                queue.add(node);
                root = node.right;
            }else {
                queue.add(node);
                root = null;
            }
        }
        int k = queue.size();

        // 将queue的设置好双向链表
        for (int i = 0; i < k - 1; i++) {
            // 是头节点
            if (i == 0){
                Node node = queue.get(i);
                node.left = queue.get(queue.size() - 1);
                node.right = queue.get(i + 1);
                continue;
            }

            queue.get(i).left = queue.get(i - 1);
            queue.get(i).right = queue.get(i + 1);
        }
        if (k == 1){
            queue.get(0).left = queue.get(0);
            queue.get(0).right = queue.get(0);
            return queue.get(0);
        }else {
            // 设置尾节点的前指针
            queue.get(k - 1).left = queue.get(k - 2);
            queue.get(k - 1).right = queue.get(0);
        }
        return queue.get(0);
    }

    public Node treeToDoublyList1(Node root){
        return null;
    }

    private void digui(Node root){

    }

    public static void main(String[] args) {
        Node node4 = new Node(4);
//        Node node2 = new Node(2);
//        Node node5 = new Node(5);
//        Node node1 = new Node(1);
//        Node node3 = new Node(3);
//        node4.left = node2;
//        node4.right = node5;
//        node2.left = node1;
//        node2.right = node3;
        JL_36 jl_36 = new JL_36();
        Node node = jl_36.treeToDoublyList(node4);
        while (node != null){
            System.out.println(node.val);
            node = node.right;
        }
    }
}
