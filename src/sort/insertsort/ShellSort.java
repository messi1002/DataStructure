package sort.insertsort;

import sort.Sort;

/**
 * @author: wjy
 * @date: 2020/2/11
 * @description: 插入排序类-希尔排序
 */
public class ShellSort implements Sort {

    @Override
    public void ascendSort(int[] arr, int n) {
        // Hibbard增量: Dk=2^k-1
        // 递推公式为: D1=1、D2=3、D3=7、Dk=2D(k−1)+1、D(k-1)=(Dk-1)/2
        // k     1 2 3 5  6
        // Dk(d) 1 3 7 15 31
        int d = 1;
        while (d < n / 3) {
            // D(k-1)->D(k)
            d = d * 2 + 1;
        }
        while (d >= 1) {
            // d间隔的插入排序
            // 第1个元素(索引为0)默认有序
            for (int i = d; i < n; i++) {
                // 寻找元素e合适的插入位置
                int e = arr[i], j = i;
                for (; j >= d && arr[j - d] > e; j -= d) {
                    // 向后移出空位
                    arr[j] = arr[j - d];
                }
                // 找到了合适的插入位置
                arr[j] = e;
            }
            // D(k)->D(k-1)
            d = (d - 1) / 2;
        }
    }
}
