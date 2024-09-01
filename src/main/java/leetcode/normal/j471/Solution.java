package leetcode.normal.j471;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/encode-string-with-shortest-length/description/">471. 编码最短长度的字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    // dp[i][j] 表示 string[i...j] 的做小压缩编码是多少
    String[][] dp;

    public String encode(String s) {
        int n = s.length();
        dp = new String[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = solve(s, i, j);
                if (len > 4) {
                    for (int k = i; k < j; k++) {
                        String split = dp[i][k] + dp[k + 1][j];
                        if (dp[i][j].length() > split.length()) dp[i][j] = split;
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    // 压缩 s 字符串中的 [i,j] 位置能得到的最小编码
    String solve(String s, int i, int j) {
        s = s.substring(i, j + 1);
        if (s.length() < 5) return s;
        // 找出第一个开始循环的位置
        int p = (s + s).indexOf(s, 1);
        if (p != s.length()) {
            int cnt = s.length() / p;
            return cnt + "[" + dp[i][i + p - 1] + "]";
        }
        return s;
    }
}