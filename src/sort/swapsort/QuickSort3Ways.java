package sort.swapsort;

import sort.Sort;
import sort.insertsort.AdvancedInsertSort;
import sort.util.SortHelper;

/**
 * @author: wjy
 * @date: 2020/2/13
 * @description: 交换排序类-三路快速排序
 */
public class QuickSort3Ways implements Sort {

    // 对arr[l...r]部分进行三路快速排序。
    // 将arr[l...r[分为 <v ==v >v 三部分
    private void recursion(int[] arr, int l, int r) {
        if (r - l <= 15) {
            AdvancedInsertSort.sort(arr, l, r);
            return;
        }
    
        // partition
        SortHelper.swap(arr, l, (int) (Math.random() * (r - l + 1) + r));
        // arr[l+1...lt] < v
        // arr[gt...r] > v
        // arr[lt+1...i) == v
        // 初始值的设立符合逻辑
        int value = arr[l], lt = l, gt = r + 1, i = l + 1;
        while (i < gt) {
            if (arr[i] < value) {
                // lt在i的前面，所以交换过来的arr[++lt]已经处理过了，需要i++。
                SortHelper.swap(arr, i++, ++lt);
            }
            else if (arr[i] > value) {
                // gt在i的后面，所以交换过来的arr[--gt]没有处理过，不需要i++。
                SortHelper.swap(arr, i, --gt);
            }
            else {
                i++;
            }
        }
        SortHelper.swap(arr, l, lt);
        recursion(arr, l, lt - 1);
        recursion(arr, gt, r);
    }
    
    @Override
    public void ascendSort(int[] arr, int n) {
        recursion(arr, 0, n - 1);
    }
}
