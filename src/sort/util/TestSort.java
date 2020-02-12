package sort.util;

import sort.Sort;

import java.time.Instant;

/**
 * @author: wjy
 * @date: 2020/2/11
 * @description: 检查算法性能
 */
public class TestSort {

    public static void testSort(String name, Sort sort, int[] arr, int n) {
    
        long start = Instant.now().toEpochMilli();
        sort.ascendSort(arr, n);
        long end = Instant.now().toEpochMilli();
        SortHelper.printArray(arr, n);
        System.out.println(name + "用时: " + (end - start) + "ms");
        System.out.println("排序后数组是否升序: " +  SortHelper.isAscendingOrder(arr, n));
    }
}
