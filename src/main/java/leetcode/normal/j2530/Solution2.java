package leetcode.normal.j2530;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/one-away-lcci/
 * 面试题 01.05. 一次编辑
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution2 {
    public boolean oneEditAway(String first, String second) {
        if (first.length() == 0 || second.length() == 0) {
            return (first.length() == 0 && second.length() <= 1) || (first.length() <= 1 && second.length() == 0);
        }
        // 假设 dp[i][j] 为 first[0..i-1] 和 second[0..j-1] 时的最小编辑距离
        int[][] dp = new int[first.length() + 1][second.length() + 1];
        for (int i = 0; i <= first.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= second.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= second.length(); j++) {
                // 如果 first[i-1] == second[j-1], dp[i][j] = min(dp[i-1][j-1], min(dp[i][j-1], dp[i-1][j]) + 1)
                // min(不操作，删第二个字符串，删第一个字符串)
                // 如果 first[i-1] != second[j-1], dp[i][j] = min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]) + 1
                // min(删第二个字符串，删第一个字符串， 替换字符)
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]) + 1);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
//                System.out.println(first.substring(0, i) + "|" + second.substring(0, j) + " : " + dp[i][j]);
            }
        }
//        System.out.println(dp[first.length()][second.length()]);
        return dp[first.length()][second.length()] <= 1;
    }
}
