package leetcode.normal.j515;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
 * 515. 在每个树行中找最大值
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    void dfs(TreeNode root, int depth, ArrayList<Integer> ans) {
        if (root == null) return;
        if (depth == ans.size()) {
            ans.add(root.val);
        } else if (ans.get(depth) < root.val) ans.set(depth, root.val);
        dfs(root.left, depth + 1, ans);
        dfs(root.right, depth + 1, ans);
    }
}