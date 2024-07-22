package leetcode.normal.j2101;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/detonate-the-maximum-bombs/description/">2101. 引爆最多的炸弹</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        ArrayList<Integer>[] edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] ori = bombs[i];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int[] target = bombs[j];
                if (isIn(ori[0], ori[1], ori[2], target[0], target[1])) edges[i].add(j);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            boolean[] vis = new boolean[n];
            vis[i] = true;
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            int res = 1;
            deque.add(i);
            while (!deque.isEmpty()) {
                Integer now = deque.poll();
                for (Integer to : edges[now]) {
                    if (!vis[to]) {
                        ++res;
                        vis[to] = true;
                        deque.add(to);
                    }
                }
            }
            ans = Math.max(ans, res);
        }
        return ans;
    }


    boolean isIn(int x, int y, int r, int tx, int ty) {
        long dx = x - tx, dy = y - ty;
        return dx * dx + dy * dy <= (long) r * r;
    }
}