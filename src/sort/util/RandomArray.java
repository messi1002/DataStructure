package sort.util;

/**
 * @author: wjy
 * @date: 2020/2/11
 * @description: 构造待排序的数组
 */
public class RandomArray {
    
    /**
     * 功能描述: 生成长度为n的数组，并且数组元素的范围在rangeL~rangeR之间。
     *
     * @param: [n, rangeL, rangeR]
     * @return: int[]
     * @auther: wjy
     * @date: 2020/2/12 20:27
     */
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
    
    /**
     * 功能描述: 生成近乎有序的长度为n的数组，并且可以自定义逆序对个数。
     *
     * @param: [n, swapTimes]
     * @return: int[]
     * @auther: wjy
     * @date: 2020/2/12 20:28
     */
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
