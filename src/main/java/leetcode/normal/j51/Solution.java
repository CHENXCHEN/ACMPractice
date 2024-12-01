package leetcode.normal.j51;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/n-queens/">51. N 皇后</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    StringBuilder rowBuilder;

    public List<List<String>> solveNQueens(int n) {
        rowBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) rowBuilder.append('.');
        List<List<String>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), 0, n, 0);
        return ans;
    }

    void dfs(List<List<String>> ans, ArrayList<String> cur, int colMark, int n, int step) {
        if (step == n) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < n; i++) {
            // 检查这一列和斜边是否没有
            if (((colMark >> i) & 1) == 0 && checkIfCan(cur, i)) {
                rowBuilder.setCharAt(i, 'Q');
                cur.add(rowBuilder.toString());
                rowBuilder.setCharAt(i, '.');
                dfs(ans, cur, colMark | (1 << i), n, step + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }

    boolean checkIfCan(List<String> cur, int y) {
        for (int x = cur.size() - 1, ly = y - 1, ry = y + 1; x >= 0; x--, ly--, ry++) {
            if (ly >= 0 && cur.get(x).charAt(ly) == 'Q') return false;
            if (ry < cur.get(x).length() && cur.get(x).charAt(ry) == 'Q') return false;
        }
        return true;
    }
}