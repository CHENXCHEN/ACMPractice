package leetcode.normal.j1641;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-sorted-vowel-strings/">1641. 统计字典序元音字符串的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n][5];
        for (int i = 0; i < 5; i++) dp[0][i] = 1;
        for (int i = 1; i < n; i++) {
            int ss = 0;
            for (int j = 0; j < 5; j++) {
                ss += dp[i - 1][j];
                dp[i][j] = ss;
            }
        }
        return Arrays.stream(dp[n - 1]).sum();
    }
}