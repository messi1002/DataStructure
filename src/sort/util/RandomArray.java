package sort.util;

/**
 * @author: wjy
 * @date: 2020/2/11
 * @description: 构造测试数组
 */
public class RandomArray {
    
    public static int[] generateRandomArray(int n, int rangeL, int rangeR) {
        
        int[] arr = new int[n];
        if (rangeL <= rangeR) {
            for (int i = 0; i < n; i++) {
                arr[i] = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL);
            }
        }
        else {
            System.out.println("rangeL > rangeR");
        }
        return arr;
    }
    
    public static int[] generateNearlyRandomArray(int n, int swapTimes) {
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < swapTimes; i++) {
            int x = (int) (Math.random() * n);
            int y = (int) (Math.random() * n);
            SortHelper.swap(arr, x, y);
        }
        return arr;
    }
}
