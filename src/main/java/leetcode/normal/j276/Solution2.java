package leetcode.normal.j276;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/paint-fence/description/">276. 栅栏涂色</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int numWays(int n, int k) {
        if (n == 1) return k;
        // dp[i] 表示第 i 个栅栏涂色的方案数
        int[] dp = new int[n];
        // dp[i] = (k - 1) * dp[i-1] + (k - 1) * dp[i - 2]
        //       = 与第 i - 1 个栅栏不同的颜色数 + 与第 i - 1 个栅栏相同的颜色数
        // 与第 i - 1 个栅栏不同的颜色数 = (k - 1) * dp[i - 1]
        // 与第 i - 1 个栅栏相同的颜色数 = 因为规定相同颜色不能超过 2，所以需要约束第 i - 1 与 i - 2 的颜色不同
        //                           = 因此等价于第 i - 1 与第 i - 2 颜色不同的方案数
        //                           = (k - 1) * dp[i - 2]
        dp[0] = k;
        dp[1] = k * k;
        for (int i = 2; i < n; i++) {
            dp[i] = (k - 1) * (dp[i - 1] + dp[i - 2]);
        }
        return dp[n - 1];
    }
}