package leetcode.normal.j3397;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-number-of-distinct-elements-after-operations/description/">3397. 执行操作后不同元素的最大数量</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, lastMax = nums[0] - k - 1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int left = nums[i] - k, right = nums[i] + k;
            int cur = Math.max(left, lastMax + 1);
            if (cur <= right) {
                ++ans;
                lastMax = cur;
            }
        }
        return ans;
    }
}