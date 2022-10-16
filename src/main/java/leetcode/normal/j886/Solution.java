package leetcode.normal.j886;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/possible-bipartition/">886. 可能的二分法</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] check = new int[n + 1];
        ArrayList<Integer>[] edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();
        for (int[] dislike : dislikes) {
            edges[dislike[0]].add(dislike[1]);
            edges[dislike[1]].add(dislike[0]);
        }
        for (int i = 1; i <= n; i++) {
            if (check[i] == 0) {
                if (!dfs(i, 0, check, edges)) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean dfs(int cur, int color, int[] check, ArrayList<Integer>[] edges) {
        if (check[cur] == 0) {
            check[cur] = color;
            int nextColor = (color + 1) & 1;
            ArrayList<Integer> nodes = edges[cur];
            for (Integer to : nodes) {
                if (!dfs(to, nextColor, check, edges)) {
                    return false;
                }
            }
            return true;
        }
        return check[cur] == color;
    }
}