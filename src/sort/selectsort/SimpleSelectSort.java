package sort.selectsort;

import sort.Sort;
import sort.util.SortHelper;

/**
 * @author: wjy
 * @date: 2020/2/11
 * @description: 选择排序类-简单选择排序
 * 方法：每次从左至右扫描待排序列，记下最小值的位置，并与待排序列的第一个数交换(以升序为例)。
 * 特点：①所需移动记录的次数比较少
 * ②简单选择排序是不稳定排序。
 */
public class SimpleSelectSort implements Sort {
    
    @Override
    public void ascendSort(int[] arr, int n) {
        // 升序排列
        for (int i = 0; i < n; i++) {
            // 寻找[i, n)区间里的最小值，其索引为minIndex
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
