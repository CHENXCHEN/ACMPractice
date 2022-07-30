package leetcode.normal.j1161;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/">1161. 最大层内元素和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    ArrayList<Integer> ans = new ArrayList<>();

    public int maxLevelSum(TreeNode root) {
        dfs(root, 0);
        int ret = 0;
        for (int i = 1; i < ans.size(); i++) {
            if (ans.get(ret) < ans.get(i)) ret = i;
        }
        return ret + 1;
    }

    void dfs(TreeNode root, int level) {
        if (root == null) return;
        if (level == ans.size()) ans.add(0);
        ans.set(level, ans.get(level) + root.val);
        if (root.left != null) dfs(root.left, level + 1);
        if (root.right != null) dfs(root.right, level + 1);
    }
}