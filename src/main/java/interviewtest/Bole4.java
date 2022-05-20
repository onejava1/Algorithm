package interviewtest;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Bole4 {
    //
    public ArrayList<Integer> heap_top_k (ArrayList<Integer> nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1,o2)->{
            return o2 - o1;
        });
        for (int i : nums){
            queue.add(i);
        }
        while (k != 0){
            res.add(queue.poll());
            k--;
        }
        return res;
    }

//    堆排序的手写





}
