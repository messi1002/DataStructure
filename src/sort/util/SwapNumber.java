package sort.util;

/**
 * @author: wjy
 * @date: 2020/2/11
 * @description: 交换数组中的数字
 */
public class SwapNumber {
    
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
