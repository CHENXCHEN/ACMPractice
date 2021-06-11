package leetcode.normal.j279;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/perfect-squares/
 * 279. 完全平方数
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public int numSquares(int n) {
        int maxSqrt = findMaxSqrt(n);
        int[] dp = new int[n + 10];
        for (int i = 1; i <= n; i++) dp[i] = i;
        for (int i = 2; i <= maxSqrt; i++) {
            int s = i * i;
            for (int j = s; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - s] + 1);
            }
        }
        return dp[n];
    }

    int findMaxSqrt(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            int s = mid * mid;
            if (s <= n) l = mid;
            else r = mid - 1;
        }
        return l;
    }
}
