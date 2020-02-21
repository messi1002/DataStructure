package sort.derivedquestion;

import sort.util.RandomArray;
import sort.util.SortHelper;

/**
 * @author: wjy
 * @date: 2020/2/13
 * @description: 求解数组中第n大元素
 */
public class TopNByQuickSort {
    
    // 对arr[l...r]部分进行partition操作。
    // 使用数组的第一个元素作为分界的标志点
    // 返回index，使得arr[l...index-1] < arr[index]; arr[index+1...r] > arr[p]
    private static int partition(int[] arr, int l, int r) {
        SortHelper.swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
        int value = arr[l], j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < value) {
                SortHelper.swap(arr, i, ++j);
            }
        }
        SortHelper.swap(arr, l, j);
        return j;
    }
    
    // 对arr[l...r]部分进行快速排序。
    private static int recursion(int[] arr, int l, int r, int N) {
        if (l >= r) {
            return 0;
        }
        int index = partition(arr, l, r), number = 0;
        if (index == N) {
            number =  arr[index];
        }
        else if (index > N) {
            number = recursion(arr, l, index - 1, N);
        }
        else {
            number = recursion(arr, index + 1, r, N);
        }
        return number;
    }
    
    public static void main(String[] args) {
        int n = 100000, N = (int) (Math.random() * n);
        int[] arr = RandomArray.generateRandomArray(n, 0, n);
        System.out.println(recursion(arr, 0, n - 1, N));
    }
}
