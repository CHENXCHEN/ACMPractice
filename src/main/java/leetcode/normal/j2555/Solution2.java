package leetcode.normal.j2555;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximize-win-from-two-segments/description/">2555. 两个线段获得的最多奖品</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length;
        // dp[i] 表示到 i - 1 为止，不超过 k 的最大礼物数
        int[] dp = new int[n + 1];
        int ans = 0;
        for (int i = 0, last = 0; i < n; i++) {
            while (prizePositions[i] - prizePositions[last] > k) last++;
            ans = Math.max(ans, i - last + 1 + dp[last]);
            dp[i + 1] = Math.max(dp[i], i - last + 1);
        }
        return ans;
    }
}