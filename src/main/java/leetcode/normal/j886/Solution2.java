package leetcode.normal.j886;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/possible-bipartition/">886. 可能的二分法</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] check = new int[n + 1], pa = new int[n + 1];
        ArrayList<Integer>[] edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
            pa[i] = i;
        }
        for (int[] dislike : dislikes) {
            edges[dislike[0]].add(dislike[1]);
            edges[dislike[1]].add(dislike[0]);
        }
        for (int i = 1; i <= n; i++) {
            if (!edges[i].isEmpty()) {
                int first = edges[i].get(0);
                for (Integer to : edges[i]) {
                    union(first, to, pa);
                    if (find(i, pa) == find(to, pa)) return false;
                }
            }
        }
        return true;
    }

    int find(int x, int[] pa) {
        if (x == pa[x]) return x;
        return pa[x] = find(pa[x], pa);
    }

    void union(int x, int y, int[] pa) {
        int faX = find(x, pa), faY = find(y, pa);
        pa[faX] = faY;
    }
}