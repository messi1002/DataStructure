package sort.util;

/**
 * @author: wjy
 * @date: 2020/2/11
 * @description: 验证数组是否有序
 */
public class OrderedArray {
    
    public static boolean isAscendingOrder(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isDescendingOrder(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}