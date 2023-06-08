package leetcode.normal.j1240;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/tiling-a-rectangle-with-the-fewest-squares/">1240. 铺瓷砖</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    boolean[][] rect;
    int ans, n, m;

    public int tilingRectangle(int n, int m) {
        this.n = n;
        this.m = m;
        rect = new boolean[n][m];
        ans = Math.max(n, m);
        dfs(0, 0, 0);
        return ans;
    }

    void dfs(int x, int y, int cnt) {
        // 如果当前数量大于 答案ans，那么就没必要继续枚举下去
        if (cnt >= ans) return;
        // 如果超过第 n 行，那么代表已经枚举完了，直接结束
        if (x >= n) {
            ans = cnt;
            return;
        }
        // 如果当前的列超过了限制，那么从下一行开始
        if (y >= m) {
            dfs(x + 1, 0, cnt);
            return;
        }
        // 如果当前位置已经被覆盖，那么从下一列开始处理
        if (rect[x][y]) {
            dfs(x, y + 1, cnt);
            return;
        }
        // 如果当前没有被覆盖，那么看从当前位置开始能放置的最大正方形
        for (int k = Math.min(n - x, m - y); k >= 1 && isValid(x, y, k); k--) {
            // 将长度为 k 的正方形覆盖
            fillUp(x, y, k, true);
            // 计数 +1
            dfs(x, y + k, cnt + 1);
            // 将长度为 k 的正方形取消覆盖
            fillUp(x, y, k, false);
        }
    }

    boolean isValid(int x, int y, int k) {
        for (int i = x; i < x + k; i++) {
            for (int j = y; j < y + k; j++) {
                if (rect[i][j]) return false;
            }
        }
        return true;
    }

    void fillUp(int x, int y, int k, boolean val) {
        for (int i = x; i < x + k; i++) {
            for (int j = y; j < y + k; j++) {
                rect[i][j] = val;
            }
        }
    }
}