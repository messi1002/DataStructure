package sort.selectsort;

import sort.Sort;
import sort.util.SortHelper;

/**
 * @author: wjy
 * @date: 2020/2/11
 * @description: 选择排序类-简单选择排序
 */
public class SimpleSelectSort implements Sort {
    
    @Override
    public void ascendSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            // 寻找[i, n)区间里的最小值，其索引为minIndex。
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            SortHelper.swap(arr, i, minIndex);
        }
    }
}
