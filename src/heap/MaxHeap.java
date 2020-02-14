package heap;

/**
 * @author: wjy
 * @date: 2020/2/14
 * @description: 最大堆
 */
public class MaxHeap {
    
    private int[] arr;
    private int count;
    private int capacity;
    
    public MaxHeap(int n) {
        arr = new int[n + 1];
        count = 0;
        this.capacity = n;
    }
    
    private void swap(int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    
    // 将index索引处的元素向上移动来维持堆的定义(入队)
    private void shiftUp(int index) {
        // 防止越界
        while (index > 1 && arr[index / 2] < arr[index]) {
            swap(index / 2, index);
            index /= 2;
        }
    }
    
    // 出队
    private void shiftDown(int index) {
        // 判断是否有左孩子
        // 哪个孩子大，就和哪个孩子换。
        while (index * 2 <= count) {
            int lc = index * 2, rc = lc + 1, res = lc;
            if (rc <= count && arr[rc] > arr[lc]) {
                res = rc;
            }
            if (arr[index] >= arr[res]) {
                break;
            }
            swap(index, res);
            index = res;
        }
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
    
    public void insert(int e) {
        if (count + 1 > capacity) {
            return;
        }
        arr[++count] = e;
        shiftUp(count);
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
