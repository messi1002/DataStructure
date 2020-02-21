package search.binarysearch;

/**
 * @author: wjy
 * @date: 2020/2/21
 * @description: 二分查找法的扩展问题: 当数组中存在多个target值时，应该返回什么？
 * 为了解决这个问题，我们额外定义两个函数:
 * ①floor()函数: 返回target在数组中第一次出现的位置，若是元素不存在，返回数组中小于target的最大元素。
 * ②ceil()函数: 返回target在数组中最后一次出现的位置，若是元素不存在，返回数组中大于target的最小元素。
 */
public class BinarySearchExtend {
    
    public static int floor(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] < target) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        // 所有元素都小于target
        if (l == arr.length) {
            return l - 1;
        }
        return arr[l] == target? l: l - 1;
    }
    
    public static int ceil(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] > target) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        // 所有元素都大于target
        if (r < 0) {
            return 0;
        }
        // 所有元素都小于target
        if (l == arr.length) {
            return l - 1;
        }
        return arr[r] == target? r: r + 1;
    }
    
    /**
     * 功能描述: 测试floor()函数和ceil()函数
     *
     * @param: [args]
     * @return: void
     * @auther: wjy
     * @date: 2020/2/21 20:39
     */
    public static void main(String[] args) {
    
        int[] arr = {0, 1, 3, 4, 4, 4, 4, 5, 6, 6};
        int random = (int) (Math.random() * arr.length);
        System.out.println("floor(arr, " + random  + ") = " + floor(arr, random));
        System.out.println("ceil(arr, " + random  + ") = " + ceil(arr, random));
    }
}
