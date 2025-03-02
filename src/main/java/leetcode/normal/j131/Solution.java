package leetcode.normal.j131;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/palindrome-partitioning/description/">131. 分割回文串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    // checked[i][j] 表示区间 [i,j] 是不是回文串
    boolean[][] checked;
    String s;
    List<List<String>> ans;
    int n;

    public List<List<String>> partition(String s) {
        this.s = s;
        this.n = s.length();
        this.checked = new boolean[n][n];
        this.ans = new ArrayList<>();
        for (int i = 0; i < n; i++) Arrays.fill(checked[i], true);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                checked[i][j] = s.charAt(i) == s.charAt(j) && checked[i + 1][j - 1];
            }
        }
        solve(0, new ArrayList<>());
        return ans;
    }

    void solve(int idx, List<String> res) {
        if (idx == n) {
            ans.add(new ArrayList<>(res));
            return;
        }
        for (int j = idx; j < n; j++) {
            if (checked[idx][j]) {
                res.add(s.substring(idx, j + 1));
                solve(j + 1, res);
                res.remove(res.size() - 1);
            }
        }
    }
}