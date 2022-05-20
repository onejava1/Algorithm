package leetcode.medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class JLII_76 {
    // 找到数组中第K大的数字 使用堆排序
    public int findKthLargest(int[] nums, int k) {
        for (int i : nums){
            insert(i);
        }
        int tmp = k - 1;
        while (tmp != 0){
            delete();
            tmp--;
        }
        return arrayList.get(0);
    }

    List<Integer> arrayList = new ArrayList<>();
    int size = 0;
    // 堆排序 构建大根堆
    public void insert(int x){
        arrayList.add(x);
        heapify(arrayList);
    }

    // 删除大根堆的元素 将末尾元素给移到头节点
    public void delete(){
        int tmp = arrayList.get(arrayList.size() - 1);
        arrayList.remove(arrayList.size() - 1);
        arrayList.set(0, tmp);
        adjustment(arrayList, 0);
    }

    // 大根堆
    private void adjustment(List<Integer> arrayList, int i){
        int left = 2 * i + 1;
        while (left <= arrayList.size() - 1){
            int right = left + 1 >= arrayList.size() ? left : left + 1;
            int maxChildIndex = arrayList.get(left) > arrayList.get(right) ? left : right;
            if (arrayList.get(i) < arrayList.get(maxChildIndex)){
                swap(i, maxChildIndex, arrayList);
                i = maxChildIndex;
                left = 2 * i + 1;
            }else {
                break;
            }
        }

    }

    private void heapify(List<Integer> arrayList){
        int now = arrayList.size() - 1;
        int parent = (now - 1) / 2;
        while (now != 0){
            if(arrayList.get(now) > arrayList.get(parent)) {
                swap(now, parent, arrayList);
                now = parent;
                parent = (now - 1) / 2;
            }else {
                break;
            }
        }

    }

    private void swap(int i, int j, List<Integer> list){
        int tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }


    public void quickSort(int[] nums,int left,int right, int k){
        if (left >= right) {
            return;
        }
        int q = nums[(left + right) / 2];
        int l = left - 1;
        int r = right + 1;
        while (l<r){
            do {
                l++;
            }while (nums[l] > q);

            do {
                r--;
            }while (nums[r] < q);

            if (l<r){
                int temp=nums[l];
                nums[l]=nums[r];
                nums[r]=temp;
            }
        }
        // size代表 左边有多少个数字 大于mid的数字
        int size = r - left + 1;
        if (k <= size) {
            quickSort(nums, left, r, k);
        } else {
            quickSort(nums,r + 1, right,k - size);
        }

    }
    public int findKthLargest1(int[] nums, int k) {
        quickSort(nums,0, nums.length-1,k);
        return nums[k-1];
    }

    public static void main(String[] args) {
        JLII_76 l = new JLII_76();
        int[] help = {3,2,1,5,6,4};
        System.out.println(l.findKthLargest1(help, 2));

    }
}
