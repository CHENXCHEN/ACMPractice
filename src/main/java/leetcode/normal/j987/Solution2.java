package leetcode.normal.j987;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/vertical-order-traversal-of-a-binary-tree/description/">987. 二叉树的垂序遍历</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    ArrayList<int[]> res;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, 0, 0);
        res.sort((x, y) -> {
            if (x[1] != y[1]) return Integer.compare(x[1], y[1]);
            else if (x[0] != y[0]) return Integer.compare(x[0], y[0]);
            else return Integer.compare(x[2], y[2]);
        });
        ArrayList<List<Integer>> ans = new ArrayList<>();
        int lastCol = Integer.MIN_VALUE;
        for (int[] it : res) {
            if (it[1] != lastCol) {
                lastCol = it[1];
                ans.add(new ArrayList<>());
            }
            ans.get(ans.size() - 1).add(it[2]);
        }
        return ans;
    }

    void dfs(TreeNode head, int row, int col) {
        if (head == null) return;
        res.add(new int[]{row, col, head.val});
        dfs(head.left, row + 1, col - 1);
        dfs(head.right, row + 1, col + 1);
    }
}