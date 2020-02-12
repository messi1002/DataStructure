package sort.util;

/**
 * @author: wjy
 * @date: 2020/2/12
 * @description: 排序辅助函数
 */
public class SortHelper {
    
    /**
     * 功能描述: 验证数组是否有序
     *
     * @param: [arr, n]
     * @return: boolean
     * @auther: wjy
     * @date: 2020/2/12 22:31
     */
    public static boolean isAscendingOrder(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * 功能描述: 打印数组
     *
     * @param: [arr, n]
     * @return: void
     * @auther: wjy
     * @date: 2020/2/12 22:30
     */
    public static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    /**
     * 功能描述: 交换数组中的数字
     *
     * @param: [arr, i, j]
     * @return: void
     * @auther: wjy
     * @date: 2020/2/12 22:31
     */
    public static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
