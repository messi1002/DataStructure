package sort.selectsort;

import sort.Sort;
import sort.util.SortHelper;

/**
 * @author: wjy
 * @date: 2020/2/14
 * @description: 选择排序类-改进的堆排序2(原地堆排序、arr[0]处存储最大堆的第一个元素)
 */
public class AdvancedHeapSort2 implements Sort {
    
    /**
     * 功能描述: 向下调整最大堆(出队时调用)
     *
     * @param: [arr, n, index]
     * @return: void
     * @auther: wjy
     * @date: 2020/2/14 11:17
     */
    public void shiftDown(int[] arr, int n, int index) {
        int e = arr[index];
        // 判断是否有左孩子
        while (index * 2 + 1 < n) {
            // 哪个孩子大，就和哪个孩子交换。
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
    
    @Override
    public void ascendSort(int[] arr, int n) {
        // heapify: 将数组原地构建成最大堆
        // 最后一个非叶子节点的索引计算: (最后一个元素索引值-1)/2
        for (int i = (n - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(arr, n, i);
        }
        // 最大堆中第一个元素即是数组中的最大值，每次将堆中第一个元素与数组末尾的元素交换，再动态维护堆(数组长度-1)。
        for (int i = n - 1; i > 0; i--) {
            // 将当前最大堆中的最大值移到数组末尾
            SortHelper.swap(arr, 0, i);
            // 重新构建最大堆
            shiftDown(arr, i, 0);
        }
    }
}
