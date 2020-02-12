package sort.mergesort;

import sort.Sort;

/**
 * @author: wjy
 * @date: 2020/2/11
 * @description: 归并排序
 */
public class MergeSort implements Sort {
    
    protected static void merge(int[] arr, int l, int mid, int r) {
        int[] aux = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            aux[i - l] = arr[i];
        }
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j++ - l];
            }
            else if (j > r) {
                arr[k] = aux[i++ - l];
            }
            else if (aux[i - l] > aux[j - l]) {
                arr[k] = aux[j++ - l];
            }
            else {
                arr[k] = aux[i++ - l];
            }
        }
    }
    // 递归使用归并排序，对arr[l...r]的范围进行排序。
    private void recursion(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        // 发生溢出
//        int mid = (l + r) / 2;
        int mid = (l + r) >>> 1;
        recursion(arr, l, mid);
        recursion(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }
    
    @Override
    public void ascendSort(int[] arr, int n) {
        recursion(arr, 0, n - 1);
    }
}
