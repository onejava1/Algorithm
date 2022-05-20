package Test.bingfa;

public class X {
    private Integer[] sort(Integer[] numbers, boolean isDesc) {
        mergeSort(numbers, isDesc, 0, numbers.length - 1);
        return numbers;
    }

    private void mergeSort(Integer[] numbers, boolean isDesc, int left, int right){
        if(left >= right){
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSort(numbers, isDesc, left, mid);
        mergeSort(numbers, isDesc, mid + 1, right);
        merge(numbers, isDesc, left, mid, right);
    }

    private void merge(Integer[] number, boolean isDesc, int left, int mid, int right){
        Integer[] tmp = new Integer[right - left + 1];
        int l = left;
        int r = mid + 1;
        int k = 0;
        while (l <= mid && r <= right){
            if(isDesc){
                // 降序
                    tmp[k++] = number[l] > number[r] ? number[l++] : number[r++];
            }else {
                // 升序
                tmp[k++] = number[l] > number[r] ? number[r++] : number[l++];
            }
        }

        while (l <= mid){
            tmp[k++] = number[l++];
        }
        while (r <= right){
            tmp[k++] = number[r++];
        }

        for(int i = 0, i1 = left; i < tmp.length; i++, i1++){
            number[i1] = tmp[i];
        }
    }

    public static void main(String[] args) {
        Integer[] a = {2, 4, 1 ,7 ,3 , -2, -8, 11, 19};
        X x = new X();
        x.sort(a, true);
        for (Integer integer : a) {
            System.out.println(integer);
        }
    }

}