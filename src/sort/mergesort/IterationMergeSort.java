package sort.mergesort;

import sort.Sort;

/**
 * @author: wjy
 * @date: 2020/2/13
 * @description: 归并排序-自底向上的归并排序
 */
public class IterationMergeSort implements Sort {
    
    @Override
    public void ascendSort(int[] arr, int n) {
        // i: 1、2、4、8...
        for (int i = 1; i <= n; i += i) {
            for (int j = 0; j + i < n; j += i + i) {
                // 对arr[j...j+i-1]和arr[j+i...j+i+i-1]进行归并
                AdvancedMergeSort.merge(arr, j, j + i - 1, Math.min(j + i + i - 1, n - 1));
            }
        }
    }
}
