package leetcode.normal.j2218;

import java.util.Arrays;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-value-of-k-coins-from-piles/description/">2218. 从栈中取出 K 个硬币的最大面值和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        // dp[i] 表示选择 i 个硬币的最大值
        // dp[i] = dp[i-j] + sum(pile[0..j])
        int[] dp = new int[k + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (List<Integer> pile : piles) {
            for (int i = k; i > 0; i--) {
                for (int j = 0, v = 0; j < pile.size() && j < i; j++) {
                    v += pile.get(j);
                    if (dp[i - j - 1] != -1) {
                        dp[i] = Math.max(dp[i], dp[i - j - 1] + v);
                    }
                }
            }
        }
        return dp[k];
    }
}