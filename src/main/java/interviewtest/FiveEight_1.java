package interviewtest;

import java.util.HashMap;

public class FiveEight_1 {

    public int maxSubArrLength (int[] arr) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < arr.length){
            if (!map.containsKey(arr[right])){
                map.put(arr[right], right);
                right++;
            }else {
                res = Math.max(right - left, res);
                left = map.get(arr[right]) + 1;
                map.put(arr[right], right);
                right++;
            }
            if (right == arr.length){
                res = Math.max(right - left, res);
            }
        }


        return res;
    }

    public static void main(String[] args) {
        FiveEight_1 f = new FiveEight_1();
        int [] c = {1,2,3,1, 2, 3};
        System.out.println(f.maxSubArrLength(c));
    }
}
