package leetcode.normal.j1636;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/sort-array-by-increasing-frequency/">1636. 按照频率将数组升序排序</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] frequencySort(int[] nums) {
        int[] has = new int[201];
        for (int num : nums) has[num + 100]++;
        return Arrays.stream(nums).boxed().sorted((a, b) -> {
            if (has[a + 100] != has[b + 100]) return has[a + 100] - has[b + 100];
            else return b - a;
        }).mapToInt(i -> i).toArray();
    }
}