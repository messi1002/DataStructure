package sort.derivedquestion;

import sort.util.RandomArray;

/**
 * @author: wjy
 * @date: 2020/2/13
 * @description: 归并排序的思路求逆序对的个数
 */
public class ReversePairsNumber {
    
    /**
     * 功能描述: 求出在arr[l...mid]和arr[mid+1...r]有序的基础上，arr[l...r]的逆序数对个数。
     *
     * @param: [arr, l, mid, r]
     * @return: long
     * @auther: wjy
     * @date: 2020/2/13 11:42
     */
    public long merge(int[] arr, int l, int mid, int r) {
        // 初始化逆序对个数
        long number = 0;
        // 使用临时空间辅助我们完成归并过程
        int[] aux = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            aux[i - l] = arr[i];
        }
        // i和j分别指向两个有序部分的元素，k指向两个元素比较后小的那个元素的存储位置。
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            // 第一个有序部分已经遍历完成
            if (i > mid) {
                arr[k] = aux[j++ - l];
            }
            // 第二个有序部分已经遍历完成
            else if (j > r) {
                arr[k] = aux[i++ - l];
            }
            else if (aux[i - l] > aux[j - l]) {
                // aux[j-l]<aux[i-l]，说明aux[i-l...mid]之间的所有元素都与aux[j-1]构成了逆序对。
                arr[k] = aux[j++ - l];
                number += (long) (mid - i + 1);
            }
            else {
                arr[k] = aux[i++ - l];
            }
        }
        return number;
    }
    
    /**
     * 功能描述: 对arr[l...r]部分进行归并排序
     *
     * @param: [arr, l, r]
     * @return: long
     * @auther: wjy
     * @date: 2020/2/13 11:14
     */
    public long recursion(int[] arr, int l, int r) {
        if (l >= r) {
            return 0L;
        }
        // 避免发生溢出，使用位运算。
        int mid = (l + r) >>> 1;
        long number1 = recursion(arr, l, mid);
        long number2 = recursion(arr, mid + 1, r);
        return number1 + number2 + merge(arr, l, mid, r);
    }
    
    public long ascendSort(int[] arr, int n) {
        return recursion(arr, 0, n - 1);
    }
    
    public static void main(String[] args) {
        int n = 1000;
        
        // 1.测试完全有序的数组
        int[] arr = RandomArray.generateNearlyRandomArray(n, 0);
        System.out.println("测试完全有序的数组: " + new ReversePairsNumber().ascendSort(arr, n));
    
        // 2.测试逆序的数组(正确答案: n*(n-1)/2)
        for (int i = 0; i < n; i++) {
            arr[n - i - 1] = i;
        }
        System.out.println("测试逆序的数组: " + new ReversePairsNumber().ascendSort(arr, n));
    
        // 3.测试随机数组
        arr = RandomArray.generateNearlyRandomArray(n, 10);
        System.out.println("测试随机数组: " + new ReversePairsNumber().ascendSort(arr, n));
    }
}