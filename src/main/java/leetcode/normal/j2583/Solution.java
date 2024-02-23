package leetcode.normal.j2583;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/kth-largest-sum-in-a-binary-tree/description/">2583. 二叉树中的第 K 大层和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    long[] levelSum;

    public long kthLargestLevelSum(TreeNode root, int k) {
        levelSum = new long[1000001];
        dfs(root, 0);
        Arrays.sort(levelSum);
        return levelSum[levelSum.length - k] == 0 ? -1 : levelSum[levelSum.length - k];
    }

    void dfs(TreeNode cur, int step) {
        if (cur == null) return;
        levelSum[step] += cur.val;
        dfs(cur.left, step + 1);
        dfs(cur.right, step + 1);
    }
}