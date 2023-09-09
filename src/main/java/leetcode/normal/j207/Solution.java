package leetcode.normal.j207;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/course-schedule/"></a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] edges = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) edges[i] = new ArrayList<>();
        int[] ru = new int[numCourses], vis = new int[numCourses];
        for (int[] edge : prerequisites) {
            edges[edge[0]].add(edge[1]);
            ru[edge[1]]++;
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (ru[i] == 0) {
                deque.add(i);
                vis[i] = 1;
            }
        }
        while (!deque.isEmpty()) {
            Integer now = deque.poll();
            for (Integer to : edges[now]) {
                --ru[to];
                if (ru[to] == 0) {
                    if (vis[to] > 0) return false;
                    vis[to] = 1;
                    deque.add(to);
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) return false;
        }
        return true;
    }
}