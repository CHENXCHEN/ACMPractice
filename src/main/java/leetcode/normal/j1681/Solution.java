package leetcode.normal.j1681;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-incompatibility/">1681. 最小不兼容性</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumIncompatibility(int[] nums, int k) {
        int n = nums.length, group = n / k, inf = Integer.MAX_VALUE, tot = 1 << n;
        int[] dp = new int[tot];
        Arrays.fill(dp, inf);
        dp[0] = 0;
        Map<Integer, Integer> values = new HashMap<>();
        for (int mask = 1; mask < tot; mask++) {
            // 枚举的每一种个数为 group 的子集
            if (Integer.bitCount(mask) != group) continue;
            Set<Integer> seen = new HashSet<>();
            int max = 0, min = 20;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) > 0) {
                    if (seen.contains(nums[i])) break;
                    seen.add(nums[i]);
                    min = Math.min(min, nums[i]);
                    max = Math.max(max, nums[i]);
                }
            }
            if (seen.size() == group) {
                values.put(mask, max - min);
            }
        }
        for (int mask = 0; mask < tot; mask++) {
            // 枚举所有情况
            if (dp[mask] == inf) continue;
            // 统计补集，并枚举补集的所有情况
            Map<Integer, Integer> seen = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0) {
                    seen.put(nums[i], i);
                }
            }
            if (seen.size() < group) continue;
            int sub = 0;
            for (int v : seen.values()) {
                sub |= 1 << v;
            }
            // 枚举补集的所有二进制子集
            int nxt = sub;
            while (nxt > 0) {
                if (values.containsKey(nxt)) {
                    // 计算 当前状态 + 子集 的最小值
                    dp[mask | nxt] = Math.min(dp[mask | nxt], dp[mask] + values.get(nxt));
                }
                nxt = (nxt - 1) & sub;
            }
        }
        return (dp[tot - 1] < inf) ? dp[tot - 1] : -1;
    }
}