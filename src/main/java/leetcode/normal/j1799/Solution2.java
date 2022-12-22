package leetcode.normal.j1799;

/**
 * Created by CHENXCHEN
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int maxScore(int[] nums) {
        int n = nums.length;
        int all = 1 << n;
        int[][] tmpGcd = new int[n][n];
        int[] dp = new int[all];
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                tmpGcd[i][j] = gcd(nums[i], nums[j]);
        for (int s = 3; s < all; s++) {
            int t = Integer.bitCount(s);
            if ((t & 1) == 1) continue;
            for (int i = 0; i < n; i++) {
                if (((s >> i) & 1) != 0) {
                    for (int j = i + 1; j < n; j++) {
                        if (((s >> j) & 1) != 0) {
                            dp[s] = Math.max(dp[s], dp[s ^ (1 << i) ^ (1 << j)] + (t >> 1) * tmpGcd[i][j]);
                        }
                    }
                }
            }
        }
        return dp[all - 1];
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}