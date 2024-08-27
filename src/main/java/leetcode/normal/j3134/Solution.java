package leetcode.normal.j3134;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-median-of-the-uniqueness-array/description/">3134. 找出唯一性数组的中位数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int medianOfUniquenessArray(int[] nums) {
        int n = nums.length;
        // 一共有 m = n * (n + 1) / 2 个子数组
        // 中位数一定位于 (m + 1) / 2 这个位置
        long median = ((long) n * (n + 1) / 2 + 1) / 2;
        int ans = 0;
        int left = 1, right = n;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (check(nums, mid, median)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    // 子数组中不同元素数目小于等于 t 的连续子数组数目是否大于等于 median
    boolean check(int[] nums, int t, long median) {
        long tot = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0, j = 0; i < nums.length; i++) {
            cnt.compute(nums[i], (kk, vv) -> (vv == null ? 0 : vv) + 1);
            while (cnt.size() > t) {
                cnt.compute(nums[j], (kk, vv) -> vv == 1 ? null : vv - 1);
                j++;
            }
            tot += i - j + 1;
        }
        return tot >= median;
    }
}