package sort.insertsort;

import sort.Sort;
import sort.util.SortHelper;

/**
 * @author: wjy
 * @date: 2020/2/11
 * @description: 插入排序类-直接插入排序
 * 优点：稳定
 * 最好的情况：顺序时-O(N)
 * 最坏的情况：逆序时-O(N^2)
 * 方法：将一条记录插入到已排好的有序表中，从而得到一个新的、记录数量增1的有序表。
 * 特点：类比整理扑克牌的思想
 */
public class DirectInsertSort implements Sort {
    
    @Override
    public void ascendSort(int[] arr, int n) {
        // 第0个元素默认有序
        for (int i = 1; i < n; i++) {
            // 寻找元素arr[i]合适的插入位置
            for (int j = i; j > 0; j--) {
                // 每次将arr[j]与其前一个位置的元素作比较
                if (arr[j] < arr[j - 1]) {
                    SortHelper.swap(arr, j, j - 1);
                }
                else {
                    // 已经找到arr[i]的合适位置，前i个元素已经全部有序
                    break;
                }
            }
//            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
//                SwapNumber.swap(arr, j, j - 1);
//            }
        }
    }
}
