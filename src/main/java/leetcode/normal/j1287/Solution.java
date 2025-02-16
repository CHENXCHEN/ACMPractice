package leetcode.normal.j1287;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/element-appearing-more-than-25-in-sorted-array/description/">1287. 有序数组中出现次数超过25%的元素</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findSpecialInteger(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.compute(arr[i], (k, v) -> v == null ? 1 : v + 1);
        }
        int n = arr.length;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() * 4 > n) return entry.getKey();
        }
        return -1;
    }
}