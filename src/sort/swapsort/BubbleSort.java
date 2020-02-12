package sort.swapsort;

import sort.Sort;
import sort.util.SortHelper;

/**
 * @author: wjy
 * @date: 2020/2/11
 * @description: 交换排序类-传统的冒泡排序
 * 相邻数字两两之间进行比较，前一个数字大则交换顺序，这样较小的数字如同气泡般慢慢浮到上面，所以称为冒泡排序法。
 * 两两比较相邻记录的关键字，如果反序则交换，直到没有反序的记录为之。
 */
public class BubbleSort implements Sort {
    
    @Override
    public void ascendSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int flag = 0;
            // 依次两两比较并交换位置后，arr[i]变为[i, n)区间里的最小值
            for (int j = n - 2; j >= i; j--) {
                if (arr[j] > arr[j + 1]) {
                    SortHelper.swap(arr, j, j + 1);
                    // 标识发生了交换。
                    flag = 1;
                }
            }
            // 全程无交换，数组已经有序。
            if (flag == 0) {
                break;
            }
        }
    }
}
