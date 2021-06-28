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
        ArrayList<TreeSet<Integer>> edges = new ArrayList<>();
        TreeMap<Integer, TreeSet<Integer>> busToNumber = new TreeMap<>();
        for (int i = 0; i < routes.length; i++) {
            edges.add(new TreeSet<>());
            for (int bus : routes[i]) {
                TreeSet<Integer> tSet = busToNumber.getOrDefault(bus, new TreeSet<Integer>());
                for (int k : tSet) {
                    if (i != k) {
                        edges.get(i).add(k);
                        edges.get(k).add(i);
                    }
                }
                tSet.add(i);
                busToNumber.put(bus, tSet);
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
            for (int next : edges.get(now)) {
                if (visit[next] == 0 || visit[next] > step + 1) {
                    visit[next] = step + 1;
                    q.add(next);
                }
            }
        }
        int ans = -1;
        for (Integer num : busToNumber.getOrDefault(target, new TreeSet<>())) {
            if (visit[num] != -1) {
                if (ans == -1 || ans > visit[num]) ans = visit[num];
            }
        }
        return ans;
    }
}
