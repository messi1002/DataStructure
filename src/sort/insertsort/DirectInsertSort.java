package sort.insertsort;

import sort.Sort;

/**
 * @author: wjy
 * @date: 2020/2/12
 * @description: 插入排序类-直接插入排序
 */
public class DirectInsertSort implements Sort {
    
    @Override
    public void ascendSort(int[] arr, int n) {
        // 第1个元素(索引为0)默认有序
        for (int i = 1; i < n; i++) {
            // 寻找元素e合适的插入位置
            int e = arr[i], j = i;
            for (; j > 0 && arr[j - 1] > e; j--) {
                // 向后移出空位
                arr[j] = arr[j - 1];
            }
            // 找到了合适的插入位置
            arr[j] = e;
        }
    }
}
