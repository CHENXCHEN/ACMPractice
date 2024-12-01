package leetcode.normal.j52;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/n-queens-ii/description/">52. N 皇后 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int ans;

    public int totalNQueens(int n) {
        ans = 0;
        dfs(0, 0, 0, n, 0);
        return ans;
    }

    void dfs(int colMark, int leftMark, int rightMark, int n, int step) {
        if (step == n) {
            ans++;
            return;
        }
        for (int i = 0; i < n; i++) {
            int cur = 1 << i;
            // 检查这一列能不能放
            if ((colMark & cur) == 0 && (leftMark & cur) == 0 && (rightMark & cur) == 0) {
                dfs(colMark | cur, (leftMark | cur) << 1, (rightMark | cur) >> 1, n, step + 1);
            }
        }
    }
}