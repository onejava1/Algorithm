package weekilycompetion;

public class L_2164 {
    public int[] sortEvenOdd(int[] nums) {
        int[] oddNumber = new int[101];
        int[] evenNumber = new int[101];
        for (int i = 0; i < nums.length; i += 2) {
            evenNumber[nums[i]]++;
        }
        for (int i = 1; i < nums.length; i += 2) {
            oddNumber[nums[i]]++;
        }

        // 偶数升序
        int i = 0;
        int k = 0;
        while (i < evenNumber.length){
            if (evenNumber[i] == 0){
            }else {
                int c = evenNumber[i];
                while (c != 0){
                    nums[k] = i;
                    k += 2;
                    c--;
                }
            }
            i++;
        }

        int c = evenNumber.length - 1;
        int kc = 1;
        while (c >= 0){
            if (oddNumber[c] == 0){
            }else {
                int cd = oddNumber[c];
                while (cd != 0){
                    nums[kc] = c;
                    kc += 2;
                    cd--;
                }
            }
            c--;
        }
        return nums;
    }

    public static void main(String[] args) {
        L_2164 l = new L_2164();
        int[] nums = {4,1,2,3};
        int[] ints = l.sortEvenOdd(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }

}
