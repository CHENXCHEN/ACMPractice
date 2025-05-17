package leetcode.normal.j361;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/bomb-enemy/description/">361. 轰炸敌人</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    static class UnionFind {
        int[] fa, vv;

        UnionFind(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
            vv = new int[n];
        }

        int find(int x) {
            return x == fa[x] ? x : (fa[x] = find(fa[x]));
        }

        void union(int u, int v) {
            int x = find(u), y = find(v);
            if (x == y) return;
            fa[x] = y;
        }

        void setV(int u, int value) {
            vv[u] = value;
        }

        int getV(int u) {
            return vv[u];
        }
    }

    public int maxKilledEnemies(char[][] grid) {
        int rows = grid.length, cols = grid[0].length, tot = rows * cols;
        UnionFind rf = new UnionFind(tot), cf = new UnionFind(tot);
        for (int i = 0; i < rows; i++) {
            for (int j = 0, cnt = 0; j < cols; j++) {
                if (grid[i][j] == 'W') {
                    cnt = 0;
                    continue;
                }
                if (grid[i][j] == 'E') ++cnt;
                int cur = i * cols + j;
                rf.setV(cur, cnt);
                if (j > 0 && grid[i][j - 1] != 'W') rf.union(i * cols + j - 1, i * cols + j);
            }
        }
        for (int j = 0; j < cols; j++) {
            for (int i = 0, cnt = 0; i < rows; i++) {
                if (grid[i][j] == 'W') {
                    cnt = 0;
                    continue;
                }
                if (grid[i][j] == 'E') ++cnt;
                int cur = i * cols + j;
                cf.setV(cur, cnt);
                if (i > 0 && grid[i - 1][j] != 'W') cf.union((i - 1) * cols + j, i * cols + j);
            }
        }
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '0') {
                    int cur = i * cols + j, rPa = rf.find(cur), cPa = cf.find(cur);
                    ans = Math.max(ans, rf.getV(rPa) + cf.getV(cPa));
                }
            }
        }
        return ans;
    }

}