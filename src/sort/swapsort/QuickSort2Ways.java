package sort.swapsort;

import sort.Sort;
import sort.insertsort.AdvancedInsertSort;
import sort.util.SortHelper;

/**
 * @author: wjy
 * @date: 2020/2/13
 * @description: 交换排序类-双路快速排序
 */
public class QuickSort2Ways implements Sort {
    
    // 返回index，使得arr[l...index-1] <= arr[index]; arr[index+1...r] >= arr[index]
    private int partition(int[] arr, int l, int r) {
        SortHelper.swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
        int value = arr[l];
        // arr[l+1...i) <= v arr[j...r] >= v
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && arr[i] < value) {
                i++;
            }
            while (j > l && arr[j] > value) {
                j--;
            }
            if (i > j) {
                break;
            }
            else {
                SortHelper.swap(arr, i++, j--);
            }
        }
        SortHelper.swap(arr, l, j);
        return j;
    }
    
    // 对arr[l...r]部分进行快速排序。
    private void recursion(int[] arr, int l, int r) {
        if (r - l <= 15) {
            AdvancedInsertSort.sort(arr, l, r);
            return;
        }
        int index = partition(arr, l, r);
        recursion(arr, l, index - 1);
        recursion(arr, index + 1, r);
    }
    
    @Override
    public void ascendSort(int[] arr, int n) {
        recursion(arr, 0, n - 1);
    }
}
