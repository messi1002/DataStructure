package sort.derivedquestion;

import sort.util.RandomArray;
import sort.util.SortHelper;

/**
 * @author: wjy
 * @date: 2020/2/13
 * @description: 求解数组中第N小的元素
 */
public class TopNByQuickSort {
    
    /**
     * 功能描述: 对arr[l...r]部分进行partition操作
     *
     * @param: [arr, l, r]
     * @return: int
     * @auther: wjy
     * @date: 2020/2/13 23:30
     */
    public static int partition(int[] arr, int l, int r) {
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
     * 功能描述: 对arr[l...r]部分进行快速排序，并寻找数组中第N小的元素。
     *
     * @param: [arr, l, r, N]
     * @return: int
     * @auther: wjy
     * @date: 2020/2/13 23:31
     */
    public static int recursion(int[] arr, int l, int r, int N) {
        if (l >= r) {
            return 0;
        }
        int index = partition(arr, l, r), number = 0;
        if (index == N) {
            number = arr[index];
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
        int n = 5, N = (int) (Math.random() * n) + 1;
        int[] arr = RandomArray.generateRandomArray(n, 0, n);
        SortHelper.printArray(arr, n);
        System.out.println("数组中第" + N + "小的元素是: " + recursion(arr, 0, n - 1, N - 1));
    }
}
