package leetcode.normal.j3038;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/ur2n8P/">剑指 Offer II 115. 重建序列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int n = nums.length;
        ArrayList<TreeSet<Integer>> edges = new ArrayList<>();
        int[] inDegree = new int[n + 1];
        for (int i = 0; i <= n; i++) edges.add(new TreeSet<>());
        for (int i = 0; i < sequences.length; i++) {
            for (int j = 1; j < sequences[i].length; j++) {
                int from = sequences[i][j - 1], to = sequences[i][j];
                inDegree[to]++;
                edges.get(from).add(to);
            }
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) deque.add(i);
        }
        int idx = 0;
        while (!deque.isEmpty()) {
            if (deque.size() > 1) return false;
            int now = deque.pop();
            if (now != nums[idx]) return false;
            ++idx;
            for (Integer next : edges.get(now)) {
                if (--inDegree[next] == 0) {
                    deque.add(next);
                }
            }
        }
        return true;
    }
}