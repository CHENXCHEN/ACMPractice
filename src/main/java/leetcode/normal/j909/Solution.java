package leetcode.normal.j909;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/snakes-and-ladders/description/">909. 蛇梯棋</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] dist = new int[n * n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        deque.add(1);
        dist[1] = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != -1) {
                    int compose = compose(i, j, n);
                    map.put(compose, board[i][j]);
                }
            }
        }
        while (!deque.isEmpty()) {
            int cur = deque.poll();
            for (int i = 1; i <= 6 && cur + i < dist.length; i++) {
                int next = cur + i;
                // 瞬移
                if (map.containsKey(next)) {
                    next = map.get(next);
                }
                if (dist[cur] + 1 < dist[next]) {
                    dist[next] = dist[cur] + 1;
                    deque.add(next);
                }
            }
        }
        return dist[n * n] == Integer.MAX_VALUE ? -1 : dist[n * n];
    }

    int compose(int x, int y, int n) {
        // (1,5) - 6
        int baseRow = (n - 1 - x) * n;
        int baseCol = (n - 1 - x) % 2 == 0 ? y : (n - 1 - y);
        return baseRow + baseCol + 1;
    }
}