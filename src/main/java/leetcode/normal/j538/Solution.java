package leetcode.normal.j538;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/delete-operation-for-two-strings/
 * 583. 两个字符串的删除操作
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int w1Len = word1.length(), w2Len = word2.length();
        int[][] dp = new int[w1Len + 1][w2Len + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= w1Len; i++) {
            for (int j = 1; j <= w2Len; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                dp[i][j] = Math.max(dp[i][j], Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        int commLen = dp[w1Len][w2Len];
        return w1Len + w2Len - (commLen << 1);
    }
}
