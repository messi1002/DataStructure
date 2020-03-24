package sort.mergesort;

import sort.Sort;

/**
 * @author: wjy
 * @date: 2020/2/11
 * @description: 归并排序
 */
public class MergeSort implements Sort {
    
    /**
     * 功能描述: 归并两个有序部分(arr[l...mid]和arr[mid+1...r])
     *
     * @param: [arr, l, mid, r]
     * @return: void
     * @auther: wjy
     * @date: 2020/2/13 3:10
     */
    public static void merge(int[] arr, int l, int mid, int r) {
        // 使用临时空间辅助我们完成归并过程
        int[] aux = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            aux[i - l] = arr[i];
        }
        // i和j分别指向两个有序部分的元素，k指向两个元素比较后小的那个元素的存储位置。
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            // 第一个有序部分已经遍历完成
            if (i > mid) {
                arr[k] = aux[j++ - l];
            }
            // 第二个有序部分已经遍历完成
            else if (j > r) {
                arr[k] = aux[i++ - l];
            }
            else if (aux[i - l] > aux[j - l]) {
                arr[k] = aux[j++ - l];
            }
            else {
                arr[k] = aux[i++ - l];
            }
        }
    }
    
    /**
     * 功能描述: 对arr[l...r]部分进行归并排序
     *
     * @param: [arr, l, r]
     * @return: void
     * @auther: wjy
     * @date: 2020/2/13 3:10
     */
    public void recursion(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        // 避免发生溢出，使用位运算。
        int mid = (l + r) >>> 1;
        recursion(arr, l, mid);
        recursion(arr, mid + 1, r);
        // 归并两个有序部分(arr[l...mid]和arr[mid+1...r])
        merge(arr, l, mid, r);
    }
    
    @Override
    public void ascendSort(int[] arr, int n) {
        recursion(arr, 0, n - 1);
    }
}
