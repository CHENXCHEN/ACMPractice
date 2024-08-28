package leetcode.normal.j3144;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-substring-partition-of-equal-character-frequency/description/">3144. 分割字符频率相等的最少子字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumSubstringsInPartition(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int maxCnt = 0;
            Map<Character, Integer> cnt = new HashMap<>();
            for (int j = i; j >= 1; j--) {
                Integer curCnt = cnt.compute(s.charAt(j - 1), (kk, vv) -> (vv == null ? 0 : vv) + 1);
                maxCnt = Math.max(maxCnt, curCnt);
                if (maxCnt * cnt.size() == (i - j + 1) && dp[j - 1] != Integer.MAX_VALUE) {
                    // 如果 [1,j] 是平衡字符串，那么 [j+1,i] 也是平衡字符串时，可以更新它
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[n];
    }
}