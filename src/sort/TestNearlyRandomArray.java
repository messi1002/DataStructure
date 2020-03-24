package sort;

import sort.insertsort.DirectInsertSort;
import sort.insertsort.ShellSort;
import sort.mergesort.AdvancedIterationMergeSort;
import sort.mergesort.AdvancedMergeSort;
import sort.mergesort.IterationMergeSort;
import sort.mergesort.MergeSort;
import sort.selectsort.AdvancedHeapSort1;
import sort.selectsort.AdvancedHeapSort2;
import sort.selectsort.HeapSort;
import sort.selectsort.SimpleSelectSort;
import sort.swapsort.*;
import sort.util.RandomArray;

import java.util.Arrays;

/**
 * @author: wjy
 * @date: 2020/2/11
 * @description: 测试各个排序算法针对近乎有序的数组的排序性能
 */
public class TestNearlyRandomArray {
    
    public static void main(String[] args) {
        System.out.println("----------随机数组的长度是1000，并且定义逆序对个数为10。----------");
        int n = 1000;
        // 随机数组的长度是1000，并且定义逆序对个数为10。
        int[] arr = RandomArray.generateNearlyRandomArray(n, 10);
        TestSort.testSort("简单交换排序", new SimpleSwapSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("传统的冒泡排序", new BubbleSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("改进的冒泡排序", new AdvancedBubbleSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("简单选择排序", new SimpleSelectSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("直接插入排序", new DirectInsertSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("希尔排序", new ShellSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("归并排序", new MergeSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("改进的归并排序", new AdvancedMergeSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("自底向上的归并排序", new IterationMergeSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("改进的自底向上的归并排序", new AdvancedIterationMergeSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("快速排序", new QuickSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("改进的快速排序", new AdvancedQuickSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("双路快速排序", new QuickSort2Ways(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("三路快速排序", new QuickSort3Ways(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("堆排序", new HeapSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("改进的堆排序1", new AdvancedHeapSort1(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("改进的堆排序2", new AdvancedHeapSort2(), Arrays.copyOf(arr, n), n);
    
        System.out.println("----------随机数组的长度是100000，并且定义逆序对个数为1000。----------");
        n = 100000;
        // 随机数组的长度是100000，并且定义逆序对个数为1000。
        arr = RandomArray.generateNearlyRandomArray(n, 1000);
        TestSort.testSort("简单交换排序", new SimpleSwapSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("传统的冒泡排序", new BubbleSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("改进的冒泡排序", new AdvancedBubbleSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("简单选择排序", new SimpleSelectSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("直接插入排序", new DirectInsertSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("希尔排序", new ShellSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("归并排序", new MergeSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("改进的归并排序", new AdvancedMergeSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("自底向上的归并排序", new IterationMergeSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("改进的自底向上的归并排序", new AdvancedIterationMergeSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("快速排序", new QuickSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("改进的快速排序", new AdvancedQuickSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("双路快速排序", new QuickSort2Ways(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("三路快速排序", new QuickSort3Ways(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("堆排序", new HeapSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("改进的堆排序1", new AdvancedHeapSort1(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("改进的堆排序2", new AdvancedHeapSort2(), Arrays.copyOf(arr, n), n);
    }
}
