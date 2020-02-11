package sort;

import sort.selectsort.SimpleSelectSort;
import sort.util.InspectPerformance;
import sort.util.PrintArray;

/**
 * @author: wjy
 * @date: 2020/2/11
 * @description: 测试类
 */
public class Test {
    
    public static void main(String[] args) {
        
        int n = 1000;
        int[] arr = new int[n];
        PrintArray.printArray(arr, n);
        InspectPerformance.inspectPerformance("直接插入排序", new SimpleSelectSort(), arr, n);
        InspectPerformance.inspectPerformance("希尔排序", new SimpleSelectSort(), arr, n);
        InspectPerformance.inspectPerformance("归并排序", new SimpleSelectSort(), arr, n);
        InspectPerformance.inspectPerformance("堆排序", new SimpleSelectSort(), arr, n);
        InspectPerformance.inspectPerformance("简单选择排序", new SimpleSelectSort(), arr, n);
        InspectPerformance.inspectPerformance("传统的冒泡排序", new SimpleSelectSort(), arr, n);
        InspectPerformance.inspectPerformance("改进的冒泡排序", new SimpleSelectSort(), arr, n);
        InspectPerformance.inspectPerformance("快速排序", new SimpleSelectSort(), arr, n);
        InspectPerformance.inspectPerformance("简单交换排序排序", new SimpleSelectSort(), arr, n);
    }
}
