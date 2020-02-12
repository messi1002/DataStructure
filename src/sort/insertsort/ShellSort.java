package sort.insertsort;

import sort.Sort;

/**
 * @author: wjy
 * @date: 2020/2/11
 * @description: 插入排序类-希尔排序
 * 克服插入排序每次只交换相邻两个元素的缺点。
 */
public class ShellSort implements Sort {

    @Override
    public void ascendSort(int[] arr, int n) {
        
        // Hibbard增量：Dk = 2^k-1
        // k     1 2 3 5  6
        // Dk(d) 1 3 7 15 31
        int d = 1;
        while (d < n / 3) {
            d = (d + 1) * 2 - 1;
        }
        while (d >= 1) {
            
            // 改进的插入排序
            for (int i = d; i < n; i++) {
                int e = arr[i], j = i;
                for (; j >= d && arr[j - d] > arr[j]; j -= d) {
                    arr[j] = arr[j - d];
                }
                arr[j] = e;
            }
            
            d = (d + 1) / 2 - 1;
        }
    }
}
