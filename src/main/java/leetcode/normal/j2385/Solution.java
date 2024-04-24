package leetcode.normal.j2385;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/amount-of-time-for-binary-tree-to-be-infected/description/">2385. 感染二叉树需要的总时间</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    Map<Integer, ArrayList<Integer>> edges;

    public int amountOfTime(TreeNode root, int start) {
        edges = new HashMap<>();
        build(root);
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        Set<Integer> visit = new HashSet<>();
        deque.add(new int[]{start, 0});
        visit.add(start);
        int ans = 0;
        while (!deque.isEmpty()) {
            int[] pop = deque.pop();
            int u = pop[0], step = pop[1];
            ans = Math.max(ans, step);
            for (Integer v : edges.getOrDefault(u, new ArrayList<>())) {
                if (!visit.contains(v)) {
                    visit.add(v);
                    deque.add(new int[]{v, step + 1});
                }
            }
        }
        return ans;
    }

    void build(TreeNode cur) {
        if (cur == null) return;
        if (cur.left != null) {
            addEdge(cur.val, cur.left.val);
            build(cur.left);
        }
        if (cur.right != null) {
            addEdge(cur.val, cur.right.val);
            build(cur.right);
        }
    }

    void addEdge(int u, int v) {
        edges.compute(u, (kk, vv) -> vv == null ? new ArrayList<>() : vv).add(v);
        edges.compute(v, (kk, vv) -> vv == null ? new ArrayList<>() : vv).add(u);
    }
}