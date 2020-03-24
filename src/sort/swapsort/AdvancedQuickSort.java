package sort.swapsort;

import sort.Sort;
import sort.util.SortHelper;

/**
 * @author: wjy
 * @date: 2020/2/13
 * @description: 交换排序类-改进的快速排序
 */
public class AdvancedQuickSort implements Sort {
    
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
     * 功能描述: 对arr[l...r]部分进行partition操作
     * 返回index，使得arr[l...index-1] < arr[index]、arr[index+1...r] >= arr[index]。
     * @param: [arr, l, r]
     * @return: int
     * @auther: wjy
     * @date: 2020/2/13 11:05
     */
    public int partition(int[] arr, int l, int r) {
        // 优化2: 使用数组中的随机元素作为分界的标志点
        SortHelper.swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
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
     * @date: 2020/2/13 11:04
     */
    public void recursion(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        // 优化1: 当n小到一定程度时，插入排序比快速排序快，此时用插入排序代替快速排序。
        if (r - l <= 15) {
            sort(arr, l, r);
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
