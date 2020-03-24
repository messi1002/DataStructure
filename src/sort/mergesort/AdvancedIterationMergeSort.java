package sort.mergesort;

import sort.Sort;

/**
 * @author: wjy
 * @date: 2020/3/13
 * @description: 归并排序-改进的自底向上的归并排序
 */
public class AdvancedIterationMergeSort implements Sort {
    
    /**
     * 功能描述: 对arr[l...r]部分进行插入排序
     *
     * @param: [arr, l, r]
     * @return: void
     * @auther: wjy
     * @date: 2020/2/13 0:10
     */
    public static void sort(int[] arr, int l, int r) {
        // 第1个元素(索引为l)默认有序
        for (int i = l + 1; i <= r; i++) {
            // 寻找元素e合适的插入位置
            int e = arr[i], j = i;
            for (; j > l && arr[j - 1] > e; j--) {
                // 向后移出空位
                arr[j] = arr[j - 1];
            }
            // 找到了合适的插入位置
            arr[j] = e;
        }
    }
    
    @Override
    public void ascendSort(int[] arr, int n) {
        // 优化1: 当n小到一定程度时，插入排序比归并排序快，此时用插入排序代替归并排序。
        for (int i = 0; i < n; i += 16) {
            sort(arr, i, Math.min(i + 15, n - 1));
        }
        // i: 16、32、64...
        for (int i = 16; i <= n; i += i) {
            for (int j = 0; j + i < n; j += i + i) {
                // 优化2: 如果两部分各自有序，就不需要继续归并了。
                if (arr[j + i - 1] > arr[j + i]) {
                    AdvancedMergeSort.merge(arr, j, j + i - 1, Math.min(j + i + i - 1, n - 1));
                }
            }
        }
    }
}
