package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// 最多可以参加的会议数目 贪心思想：对于每一天开始的而言 我们只需要选择
public class L_1353 {

    public static int maxEvents1(int[][] events) {
        // 排序完成
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        // 选择最早开始的
        int currentDay = events[0][0];
        int res = 0;
        int pre = 0;
        int index = 0;
        while (index < events.length || !priorityQueue.isEmpty()){
            while (index < events.length && events[index][0] == currentDay){
                priorityQueue.add(events[index][1]);
                index++;
            }

            // 删除不符合条件的
            while (!priorityQueue.isEmpty() && priorityQueue.peek() < currentDay){
                priorityQueue.poll();
            }

            // 筛选一个最早的出来
            if (!priorityQueue.isEmpty()){
                priorityQueue.poll();
                res++;
            }
            currentDay++;
        }
        return res;
    }




    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


    public static void main(String[] args) {
         int[][] c =  {{8,12},{10,11},{11,12}};

         String a = "aa";
         String b = new String("aa");
        System.out.println(a == b);
    }

}



