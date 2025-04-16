package leetcode.normal.j2537;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-the-number-of-good-subarrays/description/">2537. 统计好子数组的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        long ans = 0, same = 0;
        for (int left = 0, right = -1; left < nums.length; left++) {
            while (same < k && right + 1 < n) {
                ++right;
                same += cnt.getOrDefault(nums[right], 0);
                cnt.compute(nums[right], (key, val) -> val == null ? 1 : val + 1);
            }
            if (same >= k) {
                ans += n - right;
            }
            cnt.compute(nums[left], (key, val) -> val - 1);
            same -= cnt.getOrDefault(nums[left], 0);
        }
        return ans;
    }
}