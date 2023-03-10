package leetcode.normal.j1590;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/make-sum-divisible-by-p/"></a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int minSubarray(int[] nums, int p) {
        int x = 0;
        for (int num : nums) {
            x = (x + num) % p;
        }
        if (x == 0) return 0;
        // 枚举前缀和ss，并找到使得 (sum(nums) % p - ss % p) == 0 的最后的那个下标，哈希记录即可
        Map<Integer, Integer> mm = new HashMap<>();
        int ss = 0, n = nums.length, ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            mm.put(ss, i);
            ss = (ss + nums[i]) % p;
            Integer pre = mm.get((ss - x + p) % p);
            if (pre != null) {
                ans = Math.min(ans, i - pre + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}