package sort.swapsort;

import sort.Sort;
import sort.util.SortHelper;

/**
 * @author: wjy
 * @date: 2020/2/13
 * @description: 交换排序类-三路快速排序
 */
public class QuickSort3Ways implements Sort {
    
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
     * 功能描述: 对arr[l...r]部分进行三路快速排序
     * 将arr[l...r]分为 < value、== value、> value 三部分。
     * @param: [arr, l, r]
     * @return: void
     * @auther: wjy
     * @date: 2020/2/13 11:09
     */
    public void recursion(int[] arr, int l, int r) {
        if (r - l <= 15) {
            sort(arr, l, r);
            return;
        }
        // partition
        SortHelper.swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
        // arr[l+1...lt] < v、arr[lt+1...gt-1] == v、arr[gt...r] > v。
        int value = arr[l], lt = l, gt = r + 1, i = l + 1;
        while (i < gt) {
            if (arr[i] < value) {
                // 交换过来的arr[++lt]已经处理过，需要i++。
                SortHelper.swap(arr, i++, ++lt);
            }
            else if (arr[i] > value) {
                // 交换过来的arr[--gt]没有处理过，不需要i++。
                SortHelper.swap(arr, i, --gt);
            }
            else {
                i++;
            }
        }
        // 将value移到分界处
        SortHelper.swap(arr, l, lt);
        recursion(arr, l, lt - 1);
        recursion(arr, gt, r);
    }
    
    @Override
    public void ascendSort(int[] arr, int n) {
        recursion(arr, 0, n - 1);
    }
}
