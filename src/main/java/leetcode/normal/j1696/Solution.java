package leetcode.normal.j1696;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/jump-game-vi/description/">1696. 跳跃游戏 VI</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        TreeMap<Integer, Set<Integer>> tMap = new TreeMap<>();
        tMap.put(dp[0], new HashSet<Integer>() {{
            add(0);
        }});
        for (int i = 1; i < n; i++) {
            dp[i] = tMap.lastKey() + nums[i];
            Set<Integer> ss = tMap.getOrDefault(dp[i], new HashSet<>());
            ss.add(i);
            if (ss.size() == 1) tMap.put(dp[i], ss);
            if (i - k >= 0) {
                Set<Integer> x = tMap.get(dp[i - k]);
                x.remove(i - k);
                if (x.isEmpty()) tMap.remove(dp[i - k]);
            }
        }
        return dp[n - 1];
    }
}