package sort;

import sort.insertsort.AdvancedInsertSort;
import sort.insertsort.DirectInsertSort;
import sort.insertsort.ShellSort;
import sort.mergesort.MergeSort;
import sort.selectsort.HeapSort;
import sort.selectsort.SimpleSelectSort;
import sort.swapsort.AdvancedBubbleSort;
import sort.swapsort.BubbleSort;
import sort.swapsort.QuickSort;
import sort.swapsort.SimpleSwapSort;
import sort.util.RandomArray;
import sort.util.SortHelper;
import sort.util.TestSort;

import java.util.Arrays;

/**
 * @author: wjy
 * @date: 2020/2/11
 * @description: 测试各个排序算法针对近乎有序数组的排序性能
 */
public class TestNearlyRandomArray {
    
    public static void main(String[] args) {
        
        int n = 1000;
        int[] arr = RandomArray.generateNearlyRandomArray(n, 10);
        SortHelper.printArray(arr, n);
        TestSort.testSort("简单交换排序", new SimpleSwapSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("直接插入排序", new DirectInsertSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("简单选择排序", new SimpleSelectSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("改进的插入排序", new AdvancedInsertSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("传统的冒泡排序", new BubbleSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("改进的冒泡排序", new AdvancedBubbleSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("希尔排序", new ShellSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("堆排序", new HeapSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("归并排序", new MergeSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("快速排序", new QuickSort(), Arrays.copyOf(arr, n), n);
        
        arr = RandomArray.generateNearlyRandomArray(n, 100);
        SortHelper.printArray(arr, n);
        TestSort.testSort("简单交换排序", new SimpleSwapSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("直接插入排序", new DirectInsertSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("简单选择排序", new SimpleSelectSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("改进的插入排序", new AdvancedInsertSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("传统的冒泡排序", new BubbleSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("改进的冒泡排序", new AdvancedBubbleSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("希尔排序", new ShellSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("堆排序", new HeapSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("归并排序", new MergeSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("快速排序", new QuickSort(), Arrays.copyOf(arr, n), n);
        
        n = 100000;
        arr = RandomArray.generateNearlyRandomArray(n, 1000);
        TestSort.testSort("简单交换排序", new SimpleSwapSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("直接插入排序", new DirectInsertSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("简单选择排序", new SimpleSelectSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("改进的插入排序", new AdvancedInsertSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("传统的冒泡排序", new BubbleSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("改进的冒泡排序", new AdvancedBubbleSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("希尔排序", new ShellSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("堆排序", new HeapSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("归并排序", new MergeSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("快速排序", new QuickSort(), Arrays.copyOf(arr, n), n);
    
        arr = RandomArray.generateNearlyRandomArray(n, 10000);
        TestSort.testSort("简单交换排序", new SimpleSwapSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("直接插入排序", new DirectInsertSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("简单选择排序", new SimpleSelectSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("改进的插入排序", new AdvancedInsertSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("传统的冒泡排序", new BubbleSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("改进的冒泡排序", new AdvancedBubbleSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("希尔排序", new ShellSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("堆排序", new HeapSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("归并排序", new MergeSort(), Arrays.copyOf(arr, n), n);
        TestSort.testSort("快速排序", new QuickSort(), Arrays.copyOf(arr, n), n);
    }
}
