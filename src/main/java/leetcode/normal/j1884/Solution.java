package leetcode.normal.j1884;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/egg-drop-with-2-eggs-and-n-floors/description/">1884. 鸡蛋掉落-两枚鸡蛋</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int twoEggDrop(int n) {
        // dp[i] 表示有 i 层楼的最小操作次数
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE >> 1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            // i 层楼的最小操作次数等于第一个鸡蛋选择第 k 层楼
            //      如果碎了，那么说明答案位于 [0,k-1]，最多需要 k - 1 次
            //      如果没碎，那么说明答案位于 [k,i]，就等价于 i - k 层的子问题，需要 dp[i - k] 次
            for (int k = 1; k <= i; k++) {
                dp[i] = Math.min(dp[i], Math.max(k - 1, dp[i - k]) + 1);
            }
        }
        return dp[n];
    }
}