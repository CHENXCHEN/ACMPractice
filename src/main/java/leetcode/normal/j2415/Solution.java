package leetcode.normal.j2415;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/reverse-odd-levels-of-binary-tree/description/">2415. 反转二叉树的奇数层</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    ArrayList<List<TreeNode>> res;

    public TreeNode reverseOddLevels(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, 0);
        for (List<TreeNode> sub : res) {
            int left = 0, right = sub.size() - 1;
            while (left < right) {
                swap(sub.get(left), sub.get(right));
                left++;
                right--;
            }
        }
        return root;
    }

    void dfs(TreeNode root, int level) {
        if (root == null) return;
        if ((level & 1) == 1) {
            int idx = level >> 1;
            if (idx == res.size()) {
                res.add(new ArrayList<>());
            }
            res.get(idx).add(root);
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    void swap(TreeNode n1, TreeNode n2) {
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
    }
}