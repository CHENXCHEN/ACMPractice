package leetcode.normal.j1337;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/frog-position-after-t-seconds/">1377. T 秒后青蛙的位置</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    double ans;
    int target;
    Map<Integer, Set<Integer>> ed;
    int maxStep;

    public double frogPosition(int n, int[][] edges, int t, int target) {
        ed = new HashMap<>();
        ans = 0;
        maxStep = t;
        for (int[] edge : edges) {
            ed.putIfAbsent(edge[0], new HashSet<>());
            ed.putIfAbsent(edge[1], new HashSet<>());
            ed.get(edge[0]).add(edge[1]);
            ed.get(edge[1]).add(edge[0]);
        }
        this.target = target;
        ans = 0;
        findTarget(0, 1, 1.0, 0);
        return ans;
    }

    void findTarget(int parent, int now, double cur, int step) {
        Set<Integer> destNodes = ed.getOrDefault(now, new HashSet<>());
        int childSize = destNodes.size();
        if (destNodes.contains(parent)) --childSize;
        if (now == target && (childSize == 0 || step == maxStep)) {
            ans = cur;
            return;
        }
        if (step >= maxStep) return;
        for (Integer to : destNodes) {
            if (to != parent) {
                findTarget(now, to, cur / childSize, step + 1);
            }
        }
    }
}