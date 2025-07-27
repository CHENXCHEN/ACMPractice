package leetcode.normal.j272;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Double.compare(Math.abs((double) x - target), Math.abs((double) y - target)));
        dfs(root, pq);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(pq.poll());
        }
        return ans;
    }

    void dfs(TreeNode root, PriorityQueue<Integer> pq) {
        if (root == null) {
            return;
        }
        pq.add(root.val);
        dfs(root.left, pq);
        dfs(root.right, pq);
    }
}