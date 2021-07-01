package leetcode.normal.j1924;

import java.util.*;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/chuan-di-xin-xi/
 * LCP 07. 传递信息
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    static class Node {
        public Integer cur;
        public Integer step;

        Node(Integer cur, Integer step) {
            this.cur = cur;
            this.step = step;
        }
    }

    public int numWays(int n, int[][] relation, int k) {
        Map<Integer, ArrayList<Integer>> edges = new TreeMap<>();
        for (int[] rel : relation) {
            ArrayList<Integer> edg = edges.getOrDefault(rel[0], new ArrayList<>());
            if (edg.size() == 0) edges.put(rel[0], edg);
            edg.add(rel[1]);
        }
        int[][] ans = new int[k + 2][n + 2];
        for (int i = 0; i < k + 2; i++)
            for (int j = 0; j < n + 2; j++)
                ans[i][j] = 0;
        ans[0][0] = 1;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        while (!q.isEmpty()) {
            Node now = q.poll();
            Integer cur = now.cur;
            Integer step = now.step;
            if (step < k && edges.containsKey(cur))
                for (Integer next : edges.get(cur)) {
                    if (ans[step + 1][next] == 0) {
                        q.add(new Node(next, step + 1));
                    }
                    ans[step + 1][next] += ans[step][cur];
                }
        }
        return ans[k][n - 1];
    }
}
