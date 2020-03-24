package sort.selectsort;

import heap.AdvancedMaxHeap1;
import sort.Sort;

/**
 * @author: wjy
 * @date: 2020/2/11
 * @description: 选择排序类-堆排序
 */
public class HeapSort implements Sort {
    
    @Override
    public void ascendSort(int[] arr, int n) {
        AdvancedMaxHeap1 advancedMaxHeap1 = new AdvancedMaxHeap1(n);
        // 构建最大堆
        for (int i = 0; i < n; i++) {
            advancedMaxHeap1.insert(arr[i]);
        }
        // 堆排序
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = advancedMaxHeap1.removeMax();
        }
    }
}
