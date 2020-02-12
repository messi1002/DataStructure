package sort.swapsort;

import sort.Sort;
import sort.util.SortHelper;

/**
 * @author: wjy
 * @date: 2020/2/11
 * @description: 交换排序类-简单交换排序
 * 方法：每一个位置关键字与其后的所有关键字做比较，大则交换(以升序为例)。
 * 特点：将键值较大的记录向序列的尾部移动，键值较小的记录向序列的前部移动(以升序为例)。
 */
public class SimpleSwapSort implements Sort {
    
    @Override
    public void ascendSort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    SortHelper.swap(arr, i, j);
                }
            }
        }
    }
}
