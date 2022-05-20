package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L_429 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null){
            return new ArrayList<List<Integer>>();
        }
        Deque<Node> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        Node pre = root;
        queue.addFirst(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                Node n = queue.removeLast();
                list.add(n.val);
                for(Node a : n.children){
                    queue.addFirst(a);
                }
            }
            res.add(list);
        }
        return res;
    }
}
