package leetcode.normal.j655;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/print-binary-tree/">655. 输出二叉树</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int height = getMaxHeight(root, 0);
        ArrayList<List<String>> ans = new ArrayList<>();
        int rows = height + 1;
        int cols = (1 << rows) - 1;
        for (int i = 0; i < rows; i++) {
            ArrayList<String> lst = new ArrayList<>();
            for (int j = 0; j < cols; j++) lst.add("");
            ans.add(lst);
        }
        dfs(root, 0, (cols-1) >> 1, height, ans);
        return ans;
    }

    void dfs(TreeNode root, int row, int col, int height, ArrayList<List<String>> ans) {
        ans.get(row).set(col, Integer.toString(root.val));
        if (root.left != null)
            dfs(root.left, row + 1, col - (1 << (height - row - 1)), height, ans);
        if (root.right != null)
            dfs(root.right, row + 1, col + (1 << (height - row - 1)), height, ans);
    }

    int getMaxHeight(TreeNode root, int step) {
        if (root == null) return step - 1;
        return Math.max(getMaxHeight(root.left, step + 1), getMaxHeight(root.right, step + 1));
    }
}