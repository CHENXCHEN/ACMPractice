package leetcode.normal.j1457;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/pseudo-palindromic-paths-in-a-binary-tree/description/">1457. 二叉树中的伪回文路径</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int pseudoPalindromicPaths(TreeNode root) {
        int[] vis = new int[10];
        return dfs(root, vis);
    }

    int dfs(TreeNode root, int[] cnt) {
        int ans = 0;
        if (root == null) return ans;
        ++cnt[root.val];
        if (root.left == null && root.right == null) {
            if (check(cnt)) {
                ans++;
            }
        }
        ans += dfs(root.left, cnt);
        ans += dfs(root.right, cnt);
        --cnt[root.val];
        return ans;
    }

    boolean check(int[] cnt) {
        int odd = 0, even = 0;
        for (int j : cnt) {
            if (j > 0) {
                if ((j & 1) == 1) odd++;
                else even++;
            }
        }
        if (((odd + even * 2) & 1) == 1) {
            return odd == 1;
        } else {
            return odd == 0;
        }
    }
}