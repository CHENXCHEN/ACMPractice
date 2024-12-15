package leetcode.normal.j1197;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-knight-moves/description/">1197. 进击的骑士</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    Map<Pair<Integer, Integer>, Integer> mem;

    public int minKnightMoves(int x, int y) {
        mem = new HashMap<>();
        // 考虑到坐标系的对称性，我们只需要考虑第一象限的操作即可
        return dfs(Math.abs(x), Math.abs(y));
    }

    int dfs(int x, int y) {
        Pair<Integer, Integer> cur = new Pair<>(x, y);
        Integer res = mem.get(cur);
        if (res != null) return res;
        if (x + y == 0) return 0;
        else if (x + y == 2) return 2;
        else {
            // 因为原点是 (0,0)，利用对称性，从 (x,y) 出发我们只需要考虑两种操作即可
            int ret = Math.min(dfs(Math.abs(x - 2), Math.abs(y - 1)), dfs(Math.abs(x - 1), Math.abs(y - 2))) + 1;
            mem.put(cur, ret);
            return ret;
        }
    }
}