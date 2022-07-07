package niuke;

/**
 * @author huang.fei
 * @version 1.0
 * @description
 * @date 2022/6/14 22:35
 **/
public class BM18 {

    // 从左到右变大
    // 从上到下变大
    // 查找某数
    public boolean Find(int target, int [][] array) {
        if(array.length == 0 || array[0].length == 0 || array[0][0] > target){
            return false;
        }



        // 从右上角开始二分查找
        // 先对第一行进行二分查找 舍弃掉某些部分

        int serach = serach(array[0], target, true);
        if (serach == -1){
            return true;
        }
        // 二分查找
        for (int i = serach; i >= 0; i--) {
            int[] nums = new int[array.length];
            for (int j = 0; j < array.length; j++) {
                nums[j] = array[j][i];
            }
            int serach1 = serach(nums, target, false);
            if(serach1 == -1){
                return true;
            }
        }
        return false;
    }

    public int serach(int[] nums, int target, boolean isFirst){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) >> 1;
            if(nums[mid] > target){
                right = mid - 1;
            } else if(nums[mid] < target){
                if(mid + 1 < nums.length && nums[mid + 1] > target){
                    return mid;
                }
                left = mid + 1;
            } else if(nums[mid] == target){
                return -1;
            }
        }
        // -2就是没找到
        return isFirst ? nums.length - 1 : -2;
    }

    public static void main(String[] args) {
        BM18 bm18 = new BM18();
        int[][] ac = {{1, 2, 8, 9}, {4, 7, 10, 13}};
        System.out.println(bm18.Find(7, ac));
    }





}
