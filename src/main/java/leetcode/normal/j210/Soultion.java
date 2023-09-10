package leetcode.normal.j210;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/course-schedule-ii/">210. 课程表 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] edges = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) edges[i] = new ArrayList<>();
        int[] ru = new int[numCourses], vis = new int[numCourses];
        for (int[] edge : prerequisites) {
            edges[edge[1]].add(edge[0]);
            ru[edge[0]]++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (ru[i] == 0) {
                deque.add(i);
                vis[i] = 1;
                ans.add(i);
            }
        }
        while (!deque.isEmpty()) {
            Integer now = deque.poll();
            for (Integer to : edges[now]) {
                --ru[to];
                if (ru[to] == 0) {
                    if (vis[to] > 0) return new int[]{};
                    ans.add(to);
                    vis[to] = 1;
                    deque.add(to);
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) return new int[]{};
        }
        int[] ret = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) ret[i] = ans.get(i);
        return ret;
    }
}