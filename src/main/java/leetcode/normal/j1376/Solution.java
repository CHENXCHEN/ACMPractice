package leetcode.normal.j1376;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/time-needed-to-inform-all-employees/">1376. 通知所有员工所需的时间</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int ans = 0;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<Integer>[] edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] != -1) edges[manager[i]].add(i);
        }
        ans = 0;
        findMinutes(headID, informTime[headID], informTime, edges);
        return ans;
    }

    void findMinutes(int headId, int curMinutes, int[] informTime, ArrayList<Integer>[] edges) {
        ans = Math.max(ans, curMinutes);
        for (Integer to : edges[headId]) {
            findMinutes(to, curMinutes + informTime[to], informTime, edges);
        }
    }
}