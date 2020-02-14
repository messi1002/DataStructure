package sort.selectsort;

import sort.Sort;

/**
 * @author: wjy
 * @date: 2020/2/14
 * @description: 原地堆排序
 */
public class AdvancedHeapSort2 implements Sort {
    
    private void shiftDown(int[] arr, int n, int index) {
        int e = arr[index];
        while (index * 2 + 1 < n) {
            int lc = index * 2 + 1, rc = lc + 1, res = lc;
            if (rc < n && arr[rc] > arr[lc]) {
                res = rc;
            }
            if (e >= arr[res]) {
                break;
            }
            arr[index] = arr[res];
            index = res;
        }
        arr[index] = e;
    }
    
    private void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    
    @Override
    public void ascendSort(int[] arr, int n) {
        // heapify
        // 先将数组原地构建成最大堆。
        // 最后一个非叶子节点的索引计算：(最后一个元素索引值-1)/2
        for (int i = (n - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(arr, n, i);
        }
        // 最大堆中第一个元素的位置即是数组中的最大值，每次将堆中的最大值与数组末尾的元素交换，再动态维护堆(数组长度-1)。
        for (int i = n - 1; i > 0; i--) {
            // 将当前最大堆中的最大值移到数组末尾。
            swap(arr, 0, i);
            // 重新构建最大堆
            shiftDown(arr, i, 0);
        }
    }
}
