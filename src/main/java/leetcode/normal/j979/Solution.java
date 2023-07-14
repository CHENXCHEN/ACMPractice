package leetcode.normal.j979;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/distribute-coins-in-binary-tree/">979. 在二叉树中分配硬币</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int ans = 0;

    public int distributeCoins(TreeNode root) {
        // dfs(x) 表示 x 节点为根的森林需要的金币数
        // dfs(x) = 0 表示 x 为根的森林不需要额外的金币
        // dfs(x) > 0 表示 x 为根的森林多余的金币数，多余的那部分需要移动，此时要加上
        // dfs(x) < 0 表示 x 为根的森林需要的金币数，我们可以假定它欠了这么多，因此肯定需要移动一次
        ans = 0;
        dfs(root);
        return ans;
    }

    int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftNum = dfs(root.left), rightNum = dfs(root.right);
        int cur = leftNum + rightNum;
        if (root.val > 1) cur += root.val - 1;
        if (root.val == 0) cur -= 1;
        ans += Math.abs(cur);
        return cur;
    }
}