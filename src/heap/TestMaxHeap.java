package heap;

/**
 * @author: wjy
 * @date: 2020/2/14
 * @description:
 */
public class TestMaxHeap {
    
    public static void main(String[] args) {
        
        int n = 10;
        MaxHeap maxHeap = new MaxHeap(n);
        for (int i = 0; i < n; i++) {
            maxHeap.insert((int) (Math.random() * 20));
        }
        maxHeap.printArr();
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.removeMax() + " ");
        }
        System.out.println();
        
        AdvancedMaxHeap1 advancedMaxHeap1 = new AdvancedMaxHeap1(n);
        for (int i = 0; i < n; i++) {
            advancedMaxHeap1.insert((int) (Math.random() * 20));
        }
        advancedMaxHeap1.printArr();
        while (!advancedMaxHeap1.isEmpty()) {
            System.out.print(advancedMaxHeap1.removeMax() + " ");
        }
        System.out.println();
    
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = ((int) (Math.random() * 20));
        }
        AdvancedMaxHeap2 advancedMaxHeap2 = new AdvancedMaxHeap2(arr, n);
        advancedMaxHeap2.printArr();
        while (!advancedMaxHeap2.isEmpty()) {
            System.out.print(advancedMaxHeap2.removeMax() + " ");
        }
        System.out.println();
    }
}
