package sort.mergesort;

import sort.Sort;
import sort.insertsort.AdvancedInsertSort;

/**
 * @author: wjy
 * @date: 2020/2/12
 * @description: 改进的归并排序
 */
public class AdvancedMergeSort implements Sort {
    
    // 递归使用归并排序，对arr[l...r]的范围进行排序。
    private void recursion(int[] arr, int l, int r) {
        // 优化2：递归到底时，使用插入排序(排序的高级算法都可如此优化)。
        // 元素很少时，数组近乎有序的可能性变大，插入排序有优势。
        // 当N小到一定程度时，插入排序比归并排序快。
//        if (l >= r) {
//            return;
//        }
        // 什么值效果最优呢
        if (r - l <= 15) {
            AdvancedInsertSort.sort(arr, l, r);
        }
        // 发生溢出
//        int mid = (l + r) / 2;
        int mid = (l + r) >>> 1;
        recursion(arr, l, mid);
        recursion(arr, mid + 1, r);
        // 优化1：两部分各自有序，只需要判断边界。
        if (arr[mid + 1] < arr[mid]) {
            MergeSort.merge(arr, l, mid, r);
        }
    }
    
    /**
     * 功能描述: 使用递归实现自顶向下的归并排序
     *
     * @param: [arr, n]
     * @return: void
     * @auther: wjy
     * @date: 2020/2/12 23:08
     */
    public void recursionAscendSort(int[] arr, int n) {
        recursion(arr, 0, n - 1);
    }
    
    /**
     * 功能描述: 自底向上的归并排序
     *
     * @param: [arr, n]
     * @return: void
     * @auther: wjy
     * @date: 2020/2/12 23:09
     */
    @Override
    public void ascendSort(int[] arr, int n) {
        // i：递归次数
        for (int i = 1; i <= n; i += i) {
            for (int j = 0; j + i < n; j += i + i) {
                // 对arr[j...j+i-1]和arr[j+i...j+i+i-1]进行归并
                MergeSort.merge(arr, j, j + i - 1, Math.max(j + i + i - 1, n - 1));
            }
        }
        recursion(arr, 0, n - 1);
    }
}
