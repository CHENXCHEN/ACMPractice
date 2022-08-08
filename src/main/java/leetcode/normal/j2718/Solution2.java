package leetcode.normal.j2718;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/get-kth-magic-number-lcci/">面试题 17.09. 第 k 个数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution2 {
    public int getKthMagicNumber(int k) {
        int[] dp = new int[k];
        int p3 = 0, p5 = 0, p7 = 0;
        dp[0] = 1;
        for (int i = 1; i < k; i++) {
            int x3 = dp[p3] * 3, x5 = dp[p5] * 5, x7 = dp[p7] * 7;
            dp[i] = Math.min(x3, Math.min(x5, x7));
            if (dp[i] == x3) p3++;
            if (dp[i] == x5) p5++;
            if (dp[i] == x7) p7++;
        }
        return dp[k - 1];
    }
}
