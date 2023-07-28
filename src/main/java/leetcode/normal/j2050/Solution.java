package leetcode.normal.j2050;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/parallel-courses-iii/">2050. 并行课程 III</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<Integer>[] edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        int[] dis = new int[n], ru = new int[n];
        for (int[] relation : relations) {
            edges[relation[0] - 1].add(relation[1] - 1);
            ++ru[relation[1] - 1];
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (ru[i] == 0) {
                deque.push(i);
                dis[i] = time[i];
            }
        }
        while (!deque.isEmpty()) {
            Integer cur = deque.pop();
            for (Integer to : edges[cur]) {
                --ru[to];
                dis[to] = Math.max(dis[to], dis[cur] + time[to]);
                if (ru[to] == 0) {
                    deque.push(to);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) ans = Math.max(ans, dis[i]);
        return ans;
    }
}