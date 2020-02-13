package sort.derivedquestion;

/**
 * @author: wjy
 * @date: 2020/2/13
 * @description: 在归并排序的基础上修改
 */
public class ReversePairsNumber {
    
    private long merge(int[] arr, int l, int mid, int r) {
        long number = 0;
        int[] aux = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            aux[i - l] = arr[i];
        }
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j++ - l];
            }
            else if (j > r) {
                arr[k] = aux[i++ - l];
            }
            else if (aux[i - l] > aux[j - l]) {
                arr[k] = aux[j++ - l];
                number += (long) (mid - i + 1);
            }
            else {
                arr[k] = aux[i++ - l];
            }
        }
        return number;
    }
    
    // 对arr[l...r]部分进行归并排序。
    private long recursion(int[] arr, int l, int r) {
        if (l >= r) {
            return 0L;
        }
        // 发生溢出
//        int mid = (l + r) / 2;
        int mid = (l + r) >>> 1;
        long number1 = recursion(arr, l, mid);
        long number2 = recursion(arr, mid + 1, r);
        return number1 + number2 + merge(arr, l, mid, r);
    }
    
    public long ascendSort(int[] arr, int n) {
        return recursion(arr, 0, n - 1);
    }
}
