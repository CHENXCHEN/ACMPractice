package leetcode.normal.j1745;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/palindrome-partitioning-iv/description/">1745. 分割回文串 IV</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();
        boolean[][] checked = new boolean[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(checked[i], true);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                checked[i][j] = checked[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        // 枚举中间的回文串
        for (int i = 1; i < n - 1; i++) {
            for (int j = i; j < n - 1; j++) {
                if (checked[i][j] && checked[0][i - 1] && checked[j + 1][n - 1]) return true;
            }
        }
        return false;
    }
}