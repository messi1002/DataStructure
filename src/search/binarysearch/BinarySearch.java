package search.binarysearch;

/**
 * @author: wjy
 * @date: 2020/2/21
 * @description: 二分查找法: 在有序数组arr中查找target。
 * 如果找到target，返回相应的索引index。如果没有找到target，返回-1。
 * 时间复杂度: O(log n)
 */
public class BinarySearch {
    
    /**
     * 功能描述: 使用迭代的方法实现二分查找法。
     *
     * @param: [arr, target]
     * @return: int
     * @auther: wjy
     * @date: 2020/2/21 21:10
     */
    public static int binarySearch(int[] arr, int target) {
        // 在arr[l...r]之中查找target
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            // int mid = (l + r) / 2;
            // 防止极端情况下的整形溢出，用以下方法求mid。
            // int mid = l + (r - l) / 2;
            // 模仿jdk源码中的写法，无符号右移一位。
            int mid = (l + r) >>> 1;
            if (arr[mid] == target) {
                return mid;
            }
            else if (target < arr[mid]) {
                // 在arr[l...mid-1]之中查找target
                r = mid - 1;
            }
            else {
                // 在arr[mid+1...r]之中查找target
                l = mid + 1;
            }
        }
        return -1;
    }
    
    /**
     * 功能描述: 使用递归的方法实现二分查找法(性能上略差，但差异是常数级的)。
     *
     * @param: [arr, l, r, target]
     * @return: int
     * @auther: wjy
     * @date: 2020/2/21 20:58
     */
    public static int binarySearchByRecursion(int[] arr, int l, int r, int target) {
        // 在arr[l...r]之中查找target
        if (l > r) {
            return -1;
        }
        // int mid = (l + r) / 2;
        // 防止极端情况下的整形溢出，用以下方法求mid。
        // int mid = l + (r - l) / 2, index = -1;
        // 模仿jdk源码中的写法，无符号右移一位。
        int mid = (l + r) >>> 1, index = -1;
        if (arr[mid] == target) {
            index = mid;
        }
        else if (target < arr[mid]) {
            // 在arr[l...mid-1]之中查找target
            index = binarySearchByRecursion(arr, l, mid - 1, target);
        }
        else {
            // 在arr[mid+1...r]之中查找target
            index = binarySearchByRecursion(arr, mid + 1, r, target);
        }
        return index;
    }
    
    /**
     * 功能描述: 测试迭代方法和递归方法的正确性
     *
     * @param: [args]
     * @return: void
     * @auther: wjy
     * @date: 2020/2/21 20:39
     */
    public static void main(String[] args) {
        
        // 生成一个有序数组
        int n = 100;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        int random = (int) (Math.random() * n);
        System.out.println("随机数: " + random + " 迭代方法执行结果: " + binarySearch(arr, random));
        System.out.println("随机数: " + random + " 递归方法执行结果: " + binarySearchByRecursion(arr, 0, n - 1, random));
    }
}
