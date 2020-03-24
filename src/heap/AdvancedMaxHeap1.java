package heap;

import sort.util.SortHelper;

/**
 * @author: wjy
 * @date: 2020/2/14
 * @description: 改进的最大堆1(arr[1]处存储最大堆的第一个元素)
 */
public class AdvancedMaxHeap1 {
    
    private int[] arr;
    private int count;
    private int capacity;
    
    public AdvancedMaxHeap1(int n) {
        arr = new int[n + 1];
        count = 0;
        this.capacity = n;
    }
    
    /**
     * 功能描述: 向上调整最大堆(入队时调用)
     *
     * @param: [index]
     * @return: void
     * @auther: wjy
     * @date: 2020/2/14 7:44
     */
    public void shiftUp(int index) {
        int e = arr[index];
        // 防止越界
        while (index > 1 && arr[index / 2] < e) {
            // 优化1: 使用赋值操作代替交换操作
            arr[index] = arr[index / 2];
            index /= 2;
        }
        arr[index] = e;
    }
    
    /**
     * 功能描述: 向下调整最大堆(出队时调用)
     *
     * @param: [index]
     * @return: void
     * @auther: wjy
     * @date: 2020/2/14 7:44
     */
    public void shiftDown(int index) {
        int e = arr[index];
        // 判断是否有左孩子
        while (index * 2 <= count) {
            // 哪个孩子大，就和哪个孩子交换。
            int lc = index * 2, rc = lc + 1, res = lc;
            if (rc <= count && arr[rc] > arr[lc]) {
                res = rc;
            }
            if (e >= arr[res]) {
                break;
            }
            // 优化1: 使用赋值操作代替交换操作
            arr[index] = arr[res];
            index = res;
        }
        arr[index] = e;
    }
    
    /**
     * 功能描述: 判断最大堆是否为空
     *
     * @param: []
     * @return: boolean
     * @auther: wjy
     * @date: 2020/2/14 7:49
     */
    public boolean isEmpty() {
        return count == 0;
    }
    
    /**
     * 功能描述: 打印最大堆
     *
     * @param: []
     * @return: void
     * @auther: wjy
     * @date: 2020/2/14 7:50
     */
    public void printArr() {
        for (int i = 1; i <= count; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    /**
     * 功能描述: 入队
     *
     * @param: [e]
     * @return: void
     * @auther: wjy
     * @date: 2020/2/14 10:14
     */
    public void insert(int e) {
        if (count + 1 > capacity) {
            return;
        }
        arr[++count] = e;
        shiftUp(count);
    }
    
    /**
     * 功能描述: 出队
     * 最大堆中只能取出根节点
     * 为了维持完全二叉树的性质，将堆中最后一个元素移到根节点的位置，然后向下调整最大堆。
     *
     * @param: []
     * @return: int
     * @auther: wjy
     * @date: 2020/2/14 7:44
     */
    public int removeMax() {
        if (count < 1 ) {
            return 0;
        }
        // 取出根节点
        int e = arr[1];
        // 将堆中最后一个元素移到根节点的位置
        SortHelper.swap(arr, 1, count--);
        shiftDown(1);
        return e;
    }
}
