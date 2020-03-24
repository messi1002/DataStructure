package sort;

import sort.util.SortHelper;

import java.time.Instant;

/**
 * @author: wjy
 * @date: 2020/2/11
 * @description: 测试排序算法的性能
 */
public class TestSort {
    
    /**
     * 功能描述: 测试排序算法的性能，打印执行用时及排序的正确性。
     *
     * @param: [name, sort, arr, n]
     * @return: void
     * @auther: wjy
     * @date: 2020/2/12 20:41
     */
    public static void testSort(String name, Sort sort, int[] arr, int n) {
        long start = Instant.now().toEpochMilli();
        sort.ascendSort(arr, n);
        long end = Instant.now().toEpochMilli();
        System.out.println(name + "用时: " + (end - start) + "ms");
        System.out.println("排序后数组是否升序: " +  SortHelper.isAscendingOrder(arr, n));
    }
}
