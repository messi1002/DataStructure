package heap;

/**
 * @author: wjy
 * @date: 2020/2/14
 * @description:
 */
public class AdvancedMaxHeap2 {
    
    private int[] arr;
    private int count;
    
    public AdvancedMaxHeap2(int[] data, int n) {
        arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i + 1] = data[i];
        }
        count = n;
        // 从第一个不是叶子节点的节点开始，调整堆。
        // Heapify 给定一个数组，让数组的排列形成堆的形状
        // 所有的叶子节点本身就是一个最大堆。
        // 对于一个完全二叉树来说，第一个非叶子节点的索引：count/2
        for (int i = count / 2; i > 0; i--) {
            shiftDown(i);
        }
    }
    
    private void swap(int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    
    // 出队
    private void shiftDown(int index) {
        // 判断是否有左孩子
        // 哪个孩子大，就和哪个孩子换。
        int e = arr[index];
        while (index * 2 <= count) {
            int lc = index * 2, rc = lc + 1, res = lc;
            if (rc <= count && arr[rc] > arr[lc]) {
                res = rc;
            }
            if (e >= arr[res]) {
                break;
            }
            arr[index] = arr[res];
            index = res;
        }
        arr[index] = e;
    }
    
    public int size() {
        return count;
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public void printArr() {
        for (int i = 1; i <= count; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    // 只能取出根结点，然后将堆中最后一个元素移到根结点的位置(为了维持完全二叉树的性质)。
    public int removeMax() {
        if (count < 1 ) {
            return 0;
        }
        int e = arr[1];
        swap(1, count--);
        shiftDown(1);
        return e;
    }
}
