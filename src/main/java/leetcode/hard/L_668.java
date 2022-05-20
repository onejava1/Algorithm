package leetcode.hard;

/**
 * n * n乘法表中第K小的数字
 */
public class L_668 {
    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m * n;
        while(left < right){
            int mid = (left + right) >> 1;
            int totalNumber = find(mid, m, n);
            if(totalNumber > k){
                right = mid - 1;
            }else if(totalNumber == k){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }


    // 传入参数在整个矩阵当中的位次
    private int find(int l, int m, int n){
        int sum = 0;
        for(int i = 1; i <= m; i++){
            sum += searchPosition(l, i, n);
        }
        return sum;
    }

    private int searchPosition(int number, int m, int n){
        return Math.min(number / m, n);
    }




    public static void main(String[] args) {
        L_668 l = new L_668();
        System.out.println(l.findKthNumber(11, 13, 57));
    }
}
