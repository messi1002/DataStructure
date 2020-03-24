package heap;

/**
 * @author: wjy
 * @date: 2020/2/14
 * @description: 测试最大堆的构建和使用
 */
public class TestMaxHeap {
    
    public static void main(String[] args) {
        int n = 10;
        System.out.println("----------测试MaxHeap类----------");
        MaxHeap maxHeap = new MaxHeap(n);
        for (int i = 0; i < n; i++) {
            maxHeap.insert((int) (Math.random() * 20));
        }
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.removeMax() + " ");
        }
        System.out.println();
    
        System.out.println("----------测试AdvancedMaxHeap1类----------");
        AdvancedMaxHeap1 advancedMaxHeap1 = new AdvancedMaxHeap1(n);
        for (int i = 0; i < n; i++) {
            advancedMaxHeap1.insert((int) (Math.random() * 20));
        }
        while (!advancedMaxHeap1.isEmpty()) {
            System.out.print(advancedMaxHeap1.removeMax() + " ");
        }
        System.out.println();
    
        System.out.println("----------测试AdvancedMaxHeap2类----------");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = ((int) (Math.random() * 20));
        }
        AdvancedMaxHeap2 advancedMaxHeap2 = new AdvancedMaxHeap2(arr, n);
        while (!advancedMaxHeap2.isEmpty()) {
            System.out.print(advancedMaxHeap2.removeMax() + " ");
        }
        System.out.println();
    }
}
