package leetcode.normal.j560;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/subarray-sum-equals-k/description/">560. 和为 K 的子数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int s = 0, ans = 0;
        mp.put(0, 1);
        for (int i = 0; i < n; i++) {
            // curSum - preSum = k
            // curSum - k = preSum
            s += nums[i];
            ans += mp.getOrDefault(s - k, 0);
            mp.compute(s, (kk, vv) -> vv == null ? 1 : vv + 1);
        }
        return ans;
    }
}