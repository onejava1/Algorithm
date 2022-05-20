package leetcode.hard;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class JL_41 {


    Queue<Integer> A, B;
    public void MedianFinder() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }
    public void addNum(int num) {
        // A在上面
        if (A.size() != B.size()){
            // a > b
            A.add(num);
            // 接着A选出更小的数字 放入下半部分更小的数字
            B.add(A.poll());
        }else {
            B.add(num);
            A.add(B.poll());
        }
    }
    public double findMedian() {
        return A.size() == B.size() ? (A.peek() + B.peek()) / 2.0 : A.peek();
    }



    public static void main(String[] args) {
        Queue<Integer> heap = new PriorityQueue<Integer>();
        heap.add(5);
        heap.add(5);
        heap.add(5);
    }

}
