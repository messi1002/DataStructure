package sort.util;

/**
 * @author: wjy
 * @date: 2020/2/11
 * @description: 构造测试数组
 */
public class RandomArray {
    
    public int[] getRandomArray(int n, int rangeL, int rangR) {
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * (rangR - rangeL + 1) + rangeL);
        }
        return arr;
    }
}
