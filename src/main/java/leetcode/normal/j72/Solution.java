package leetcode.normal.j72;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/edit-distance/
 * 72. 编辑距离
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minDistance(String word1, String word2) {
        // 假设 dp[i][j] 为 word1[0..i-1] 和 word2[0..j-1] 时的最小编辑距离
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                // 如果 first[i-1] == second[j-1], dp[i][j] = min(dp[i-1][j-1], min(dp[i][j-1], dp[i-1][j]) + 1)
                // min(不操作，删第二个字符串，删第一个字符串)
                // 如果 first[i-1] != second[j-1], dp[i][j] = min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]) + 1
                // min(删第二个字符串，删第一个字符串， 替换字符)
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]) + 1);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
//                System.out.println(first.substring(0, i) + "|" + second.substring(0, j) + " : " + dp[i][j]);
            }
        }
//        System.out.println(dp[first.length()][second.length()]);
        return dp[word1.length()][word2.length()];
    }
}