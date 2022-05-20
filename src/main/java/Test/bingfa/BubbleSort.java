package Test.bingfa;

public class BubbleSort {

    // 冒泡排序就是每次往后面
    public int[] BubbleSort(int[] nums){
        for (int i = 0; i < nums.length; i++){
            for (int c = 0; c < nums.length - i - 1; c++){
                if (nums[c] > nums[c + 1]){
                    swap(c, c + 1, nums);
                }
            }
        }
        return nums;
    }
    private void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] help = {2, 1, 7, 3, 18 ,1 ,-3};
        BubbleSort b = new BubbleSort();
        b.BubbleSort(help);
        for (int i : help) {
            System.out.println(i);
        }
    }

}
