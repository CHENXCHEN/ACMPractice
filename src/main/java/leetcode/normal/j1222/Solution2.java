package leetcode.normal.j1222;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/queens-that-can-attack-the-king/description/">1222. 可以攻击国王的皇后</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[][] map = new boolean[8][8];
        for (int[] queen : queens) {
            map[queen[0]][queen[1]] = true;
        }
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        for (int[] d : dir) {
            int x = king[0] + d[0], y = king[1] + d[1];
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (map[x][y]) {
                    ArrayList<Integer> sub = new ArrayList<>();
                    sub.add(x);
                    sub.add(y);
                    ans.add(sub);
                    break;
                }
                x += d[0];
                y += d[1];
            }
        }
        return ans;
    }
}