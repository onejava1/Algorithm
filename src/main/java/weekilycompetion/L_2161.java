package weekilycompetion;

public class L_2161 {

    public int[] pivotArray(int[] nums, int pivot) {
        int[] res = new int [nums.length];
        int minNumber = 0;
        int eqaulNumber = 0;
        int k = 0;
        for (int num : nums) {
            if (num == pivot){
                eqaulNumber++;
            }else if (num < pivot){
                minNumber++;
            }
        }
        int c = eqaulNumber + minNumber;
        for (int num : nums) {
            if (num < pivot){
                res[k++] = num;
            }else if (num == pivot){
                res[minNumber++] = num;
            }else if (num > pivot){
                res[c++] = num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        L_2161 l = new L_2161();
        int[] nums = {9,12,5,10,14,3,10};
        int[] ints = l.pivotArray(nums, 10);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

}
