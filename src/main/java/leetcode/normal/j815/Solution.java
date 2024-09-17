package leetcode.normal.j815;

import java.util.*;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/bus-routes/
 * 815. 公交路线
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        int n = routes.length;
        // 边
        boolean[][] hasEdge = new boolean[n][n];
        ArrayList<Integer>[] edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        // 记录 bus 的编号，每个 bus 关联到有哪些 route
        TreeMap<Integer, TreeSet<Integer>> busToNumber = new TreeMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int bus : routes[i]) {
                TreeSet<Integer> tSet = busToNumber.computeIfAbsent(bus, x -> new TreeSet<>());
                for (int k : tSet) {
                    if (i != k) {
                        if (!hasEdge[i][k]) edges[i].add(k);
                        if (!hasEdge[k][i]) edges[k].add(i);
                        hasEdge[i][k] = hasEdge[k][i] = true;
                    }
                }
                tSet.add(i);
            }
        }
        int[] visit = new int[routes.length + 1];
        Arrays.fill(visit, 0);
        Queue<Integer> q = new LinkedList<>();
        for (Integer num : busToNumber.getOrDefault(source, new TreeSet<>())) {
            visit[num] = 1;
            q.add(num);
        }
        while (!q.isEmpty()) {
            Integer now = q.poll();
            int step = visit[now];
            for (int next : edges[now]) {
                if (visit[next] == 0 || visit[next] > step + 1) {
                    visit[next] = step + 1;
                    q.add(next);
                }
            }
        }
        int ans = -1;
        for (Integer num : busToNumber.getOrDefault(target, new TreeSet<>())) {
            if (visit[num] > 0) {
                if (ans == -1 || ans > visit[num]) ans = visit[num];
            }
        }
        return ans;
    }
}