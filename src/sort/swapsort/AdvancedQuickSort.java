package sort.swapsort;

import sort.Sort;
import sort.insertsort.AdvancedInsertSort;
import sort.util.SortHelper;

/**
 * @author: wjy
 * @date: 2020/2/13
 * @description: 交换排序类-改进的快速排序
 */
public class AdvancedQuickSort implements Sort {
    
    // 对arr[l...r]部分进行partition操作。
    // 使用数组中的随机元素作为分界的标志点
    // 返回index，使得arr[l...index-1] < arr[index]; arr[index+1...r] > arr[p]
    private int partition(int[] arr, int l, int r) {
        SortHelper.swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
        int value = arr[l], j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < value) {
                SortHelper.swap(arr, i, ++j);
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
