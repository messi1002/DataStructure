package sort.swapsort;

import sort.Sort;
import sort.util.SortHelper;

/**
 * @author: wjy
 * @date: 2020/2/11
 * @description: 交换排序类-传统的冒泡排序
 */
public class BubbleSort implements Sort {
    
    @Override
    public void ascendSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int flag = 0;
            // 依次两两比较并交换位置后，arr[i]变为[i, n-1]区间里的最小值。
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    SortHelper.swap(arr, j, j - 1);
                    // 标识一趟冒泡排序中发生了交换。
                    flag = 1;
                }
            }
            // 全程无交换，表明数组已经有序。
            if (flag == 0) {
                break;
            }
        }
    }
}
