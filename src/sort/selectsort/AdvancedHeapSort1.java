package sort.selectsort;

import heap.AdvancedMaxHeap2;
import sort.Sort;

/**
 * @author: wjy
 * @date: 2020/2/14
 * @description:
 * 改进构建堆的方式
 */
public class AdvancedHeapSort1 implements Sort {
    
    @Override
    public void ascendSort(int[] arr, int n) {
    
        AdvancedMaxHeap2 advancedMaxHeap2 = new AdvancedMaxHeap2(arr, n);
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = advancedMaxHeap2.removeMax();
        }
    }
}
