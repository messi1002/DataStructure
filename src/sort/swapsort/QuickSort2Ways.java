package sort.swapsort;

import sort.Sort;
import sort.util.SortHelper;

/**
 * @author: wjy
 * @date: 2020/2/13
 * @description: 交换排序类-双路快速排序
 */
public class QuickSort2Ways implements Sort {
    
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
    
    /**
     * 功能描述: 返回index，使得arr[l...index-1] <= arr[index]、arr[index+1...r] >= arr[index]。
     *
     * @param: [arr, l, r]
     * @return: int
     * @auther: wjy
     * @date: 2020/2/13 22:34
     */
    public int partition(int[] arr, int l, int r) {
        SortHelper.swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
        int value = arr[l];
        // arr[l...i) <= v、arr[j...r] >= v
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && arr[i] < value) {
                i++;
            }
            while (j > l && arr[j] > value) {
                j--;
            }
            if (i > j) {
                break;
            }
            else {
                // 此时arr[i] > value && arr[j] < value，所以直接交换它们的位置。
                SortHelper.swap(arr, i++, j--);
            }
        }
        // 将value移到分界处
        SortHelper.swap(arr, l, j);
        return j;
    }
    
    /**
     * 功能描述: 对arr[l...r]部分进行双路快速排序
     *
     * @param: [arr, l, r]
     * @return: void
     * @auther: wjy
     * @date: 2020/2/13 11:08
     */
    public void recursion(int[] arr, int l, int r) {
        if (r - l <= 15) {
            sort(arr, l, r);
            return;
        }
        int index = partition(arr, l, r);
        recursion(arr, l, index - 1);
        recursion(arr, index + 1, r);
    }
    
    @Override
    public void ascendSort(int[] arr, int n) {
        recursion(arr, 0, n - 1);
    }
}
