package sort.swapsort;

import sort.Sort;
import sort.util.SortHelper;

/**
 * @author: wjy
 * @date: 2020/2/11
 * @description: 交换排序类-改进的冒泡排序
 */
public class AdvancedBubbleSort implements Sort {
    
    @Override
    public void ascendSort(int[] arr, int n) {
        int index = -1;
        for (int i = index + 1; i < n; i++) {
            // 依次两两比较并交换位置后，arr[i]变为[i, n-1]区间里的最小值。
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    SortHelper.swap(arr, j, j - 1);
                    // 记录最后一次的交换位置，在此之前的元素(已经有序)在下一轮扫描中均不考虑。
                    index = j - 1;
                }
            }
        }
    }
}
