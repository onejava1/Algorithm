package leetcode.easy;

public class JLII_6 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right){
            int sum = numbers[left] + numbers[right];
            if (sum > target){
                right--;
            }
            if (sum < target){
                left++;
            }
            if (sum == target){
                return new int[]{left, right};
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        JLII_6 j = new JLII_6();
        int[] a = {1,2,4,6,10};
        int[] k = j.twoSum(a, 8);
        for (int i : k) {
            System.out.println(i);
        }
    }
}
