package sort.swapsort;

import sort.Sort;
import sort.util.SortHelper;

/**
 * @author: wjy
 * @date: 2020/2/11
 * @description: 交换排序类-快速排序
 */
public class QuickSort implements Sort {
    
    /**
     * 功能描述: 对arr[l...r]部分进行partition操作
     * 返回index，使得arr[l...index-1] < arr[index]、arr[index+1...r] >= arr[index]。
     *
     * @param: [arr, l, r]
     * @return: int
     * @auther: wjy
     * @date: 2020/2/13 11:10
     */
    public int partition(int[] arr, int l, int r) {
        // 使用数组的第一个元素作为分界的标志点
        int value = arr[l], j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < value) {
                SortHelper.swap(arr, i, ++j);
            }
        }
        // 将value移到分界处
        SortHelper.swap(arr, l, j);
        return j;
    }
    
    /**
     * 功能描述: 对arr[l...r]部分进行快速排序
     *
     * @param: [arr, l, r]
     * @return: void
     * @auther: wjy
     * @date: 2020/2/13 11:10
     */
    public void recursion(int[] arr, int l, int r) {
        if (l >= r) {
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
