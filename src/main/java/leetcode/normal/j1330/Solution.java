package leetcode.normal.j1330;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/reverse-subarray-to-maximize-array-value/">1330. 翻转子数组得到最大的数组值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxValueAfterReverse(int[] nums) {
        // 分类讨论：假设不翻转的值为 sum
        // 1. 翻转 [0, k]，那么最大值为 max(sum - abs(nums[k+1] - nums[k]) + abs(nums[k+1] - nums[0]))
        // 2. 翻转 [k, n - 1]，那么最大值为 max(sum - abs(nums[k] - nums[k-1]) + abs(nums[n-1] - nums[k-1]))
        // 3. 翻转 [k1, k2]，这个时候需要分类讨论 k1-1, k1, k2-1, k2 这四个位置的大小情况
        // 假设排序后为 a < b < c < d，那么一共有 4 * 3 * 2 * 1 = 24 种情况，可以缩减成 6 种情况
        // 最终只和 sum + 2 * (c - b) 有关，只跟相邻元素中的较大值和较小值有关
        int max1 = 0, n = nums.length, vv = 0;
        for (int i = 1; i < n; i++) {
            vv += Math.abs(nums[i] - nums[i - 1]);
        }
        for (int i = 1; i < n - 1; i++) {
            max1 = Math.max(max1, -Math.abs(nums[i + 1] - nums[i]) + Math.abs(nums[i + 1] - nums[0]));
            max1 = Math.max(max1, -Math.abs(nums[i] - nums[i - 1]) + Math.abs(nums[n - 1] - nums[i - 1]));
        }
        int maxNum = Integer.MIN_VALUE, minNum = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int x = nums[i], y = nums[i + 1];
            maxNum = Math.max(maxNum, Math.min(x, y));
            minNum = Math.min(minNum, Math.max(x, y));
        }
        return vv + Math.max(max1, 2 * (maxNum - minNum));
    }
}