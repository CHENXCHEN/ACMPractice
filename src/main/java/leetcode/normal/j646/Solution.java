package leetcode.normal.j646;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-length-of-pair-chain/">646. 最长数对链</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (int[] p1, int[] p2) -> {
            if (p1[0] != p2[0]) return p1[0] - p2[0];
            return p1[1] - p2[1];
        });
        int[] dp = new int[pairs.length];
        int ans = 1;
        for (int i = 0; i < pairs.length; i++) {
            int tmp = 0;
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0] && tmp < dp[j]) {
                    tmp = dp[j];
                }
            }
            dp[i] = tmp + 1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}