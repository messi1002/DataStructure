package sort.swapsort;

import sort.Sort;
import sort.util.SortHelper;

/**
 * @author: wjy
 * @date: 2020/2/11
 * @description: 交换排序类-简单交换排序
 */
public class SimpleSwapSort implements Sort {
    
    @Override
    public void ascendSort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            // 将索引i处的元素与其后的元素依次比较，若大于其后的元素就交换位置。
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    SortHelper.swap(arr, i, j);
                }
            }
        }
    }
}
