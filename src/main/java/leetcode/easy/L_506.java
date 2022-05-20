package leetcode.easy;

import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class L_506 {

    public class Node{
        public int value;
        public int index;
        Node(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
    public String[] findRelativeRanks(int[] score) {
        // 小根堆
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.value - o1.value;
            }
        });
        for (int i = 0; i < score.length; i++) {
            Node node = new Node(score[i], i);
        }
        String[] res = new String[score.length];
        int k = 0;
        while (!queue.isEmpty()){
            Node n = queue.remove();
            if (k != 3){
                String a = k == 0 ? "Gold Medal" : k == 1 ? "Silver Medal" : "Bronze Medal";

            }
            res[n.index] = String.valueOf(n.value);
        }
        return res;
    }

    public static void main(String[] args) {
        L_506 l = new L_506();
        int[] a = {5,4,3,2,1};
        String[] relativeRanks = l.findRelativeRanks(a);
        for (int i = 0; i < relativeRanks.length; i++) {
            System.out.println(relativeRanks[i]);
        }

    }
}
