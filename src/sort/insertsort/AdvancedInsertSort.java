package sort.insertsort;

import sort.Sort;

/**
 * @author: wjy
 * @date: 2020/2/12
 * @description: 插入排序类-改进的插入排序(将多次交换操作变成比较后做一次赋值操作)
 */
public class AdvancedInsertSort implements Sort {
    
    // 对arr[l...r]范围的数组进行插入排序
    public static void sort(int[] arr, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            int e = arr[i], j = i;
            for (; j > l && arr[j - 1] > e; j--) {
                // 向后覆盖
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }
    
    @Override
    public void ascendSort(int[] arr, int n) {
        // 第0个元素默认有序
        for (int i = 1; i < n; i++) {
            // 寻找元素arr[i]合适的插入位置
            // j保存元素e应该插入的位置
            int e = arr[i], j = i;
            for (; j > 0 && arr[j - 1] > e; j--) {
                // 向后覆盖
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }
}
