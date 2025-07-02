package leetcode.normal.j3333;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CHENXCHEN
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int possibleStringCount(String word, int k) {
        int mod = (int) 1e9 + 7;
        int n = word.length();
        int cnt = 1;
        List<Integer> freq = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                ++cnt;
            } else {
                freq.add(cnt);
                cnt = 1;
            }
        }
        freq.add(cnt);

        long ans = 1L;
        for (Integer o : freq) {
            ans = (ans * o) % mod;
        }
        if (freq.size() >= k) return (int) ans;

        // dp[i][j] 表示当枚举到 freq[i] 的时候，长度为 j 的方案数
        // dp[i][j] = dp[i-1][j - 1] + ... + dp[i-1][j - j'], 1 <= j' <= freq[i]
        // preSum[i] 表示上一轮 dp 的前缀和
        int[] preSum = new int[k];
        Arrays.fill(preSum, 1);
        for (int i = 0; i < freq.size(); i++) {
            int[] dp = new int[k];
            for (int j = 1; j < k; j++) {
                dp[j] = preSum[j - 1];
                if (j - freq.get(i) - 1 >= 0) {
                    // dp[i][j] = dp[i-1][j - 1] + ... + dp[i-1][j - j'], 1 <= j' <= freq[i]
                    dp[j] = (dp[j] - preSum[j - freq.get(i) - 1] + mod) % mod;
                }
            }
            int[] preSum1 = new int[k];
            // 计算 dp 的前缀和
            preSum1[0] = dp[0];
            for (int j = 1; j < k; j++) {
                preSum1[j] = (preSum1[j - 1] + dp[j]) % mod;
            }
            preSum = preSum1;
        }
        // 所有的方案数 - 小于 k 的方案数 = 至少为 k 的方案数
        return (int) ((ans - preSum[k - 1] + mod) % mod);
    }
}