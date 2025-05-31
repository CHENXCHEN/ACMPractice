package leetcode.normal.j2359;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-closest-node-to-given-two-nodes/description/">2359. 找到离给定两个节点最近的节点</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int closestMeetingNode(int[] _edges, int node1, int node2) {
        int n = _edges.length;
        ArrayList<Integer>[] edges = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            if (_edges[i] != -1) {
                edges[i].add(_edges[i]);
            }
        }

        int[] dis1 = bfs(edges, node1, n);
        int[] dis2 = bfs(edges, node2, n);
        int ans = -1, lastMin = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dis1[i] != -1 && dis2[i] != -1) {
                int curMin = Math.max(dis1[i], dis2[i]);
                if (lastMin > curMin) {
                    ans = i;
                    lastMin = curMin;
                }
            }
        }
        return ans;
    }

    int[] bfs(ArrayList<Integer>[] edges, int start, int n) {
        int[] dis = new int[n];
        Arrays.fill(dis, -1);
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        dis[start] = 0;
        while (!deque.isEmpty()) {
            int cur = deque.poll();
            for (int next : edges[cur]) {
                if (dis[next] == -1) {
                    dis[next] = dis[cur] + 1;
                    deque.add(next);
                }
            }
        }
        return dis;
    }
}