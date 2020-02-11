package sort.util;

import sort.Sort;

import java.time.Instant;

/**
 * @author: wjy
 * @date: 2020/2/11
 * @description: 检查算法性能
 */
public class InspectPerformance {

    public static void inspectPerformance(String name, Sort sort, int[] arr, int n) {
    
        long start = Instant.now().toEpochMilli();
        sort.sort(arr, n);
        long end = Instant.now().toEpochMilli();
        System.out.println(name + "用时: " + (end - start) + "ms");
        System.out.println("排序后数组是否升序: " + OrderedArray.isAscendingOrder(arr, n));
        System.out.println("排序后数组是否降序: " + OrderedArray.isDescendingOrder(arr, n));
    }
}
