package leetcode.normal.j987;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/vertical-order-traversal-of-a-binary-tree/description/">987. 二叉树的垂序遍历</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    TreeMap<Pair<Integer, Integer>, ArrayList<Integer>> tMap;
    int minCol;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        tMap = new TreeMap<>((x, y) -> x.getKey() != y.getKey() ? Integer.compare(x.getKey(), y.getKey()) : Integer.compare(x.getValue(), y.getValue()));
        minCol = Integer.MAX_VALUE;
        dfs(root, 0, 0);
        TreeMap<Integer, List<Integer>> res = new TreeMap<>();
        for (Map.Entry<Pair<Integer, Integer>, ArrayList<Integer>> entry : tMap.entrySet()) {
            res.computeIfAbsent(entry.getKey().getValue(), xx -> new ArrayList<>());
            entry.getValue().sort(Integer::compare);
            res.get(entry.getKey().getValue()).addAll(entry.getValue());
        }
        return new ArrayList<>(res.values());
    }

    void dfs(TreeNode head, int row, int col) {
        if (head == null) return;
        minCol = Math.min(minCol, col);
        tMap.compute(new Pair<>(row, col), (kk, vv) -> vv == null ? new ArrayList<>() : vv).add(head.val);
        dfs(head.left, row + 1, col - 1);
        dfs(head.right, row + 1, col + 1);
    }
}