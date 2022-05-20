package weekilycompetion;

import java.util.Arrays;

public class L_6010 {
    // 二分法
    public long minimumTime(int[] time, int totalTrips) {
        long min = Integer.MAX_VALUE;
        for (int i : time) {
            min = Math.min(i, min);
        }
        long left = 1;
        long right = totalTrips * min;

        while (left < right){
            long totalTime = 0;
            long mid = left + ((right - left) >> 1);
            for (int i : time) {
                totalTime += mid / i;
            }
            // 轮次符合要求
            if (totalTime >= totalTrips) {
                right = mid;
            }else if (totalTime < totalTrips){
                left = mid + 1;
            }
        }
        return right;
    }

    public long minimumTime1(int[] time, int totalTrips) {
        Arrays.sort(time);
        long left = 0, right = 1L * time[0] * totalTrips;
        while(left < right){
            long mid = (left + right) / 2;
            long trips = 0;
            for(int t : time){
                if(mid < t){
                    break;
                }
                trips += mid / t;
            }
            if(trips >= totalTrips){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        L_6010 l = new L_6010();
        int[] help = {1,2,3};
        System.out.println(l.minimumTime(help, 5));
    }


}
