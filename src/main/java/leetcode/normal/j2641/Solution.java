package leetcode.normal.j2641;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/cousins-in-binary-tree-ii/description/">2641. 二叉树的堂兄弟节点 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] levelSum;

    public TreeNode replaceValueInTree(TreeNode root) {
        levelSum = new int[100001];
        calcLevelSum(root, 0);
        root.val = 0;
        replaceValue(root, 0);
        return root;
    }

    void calcLevelSum(TreeNode head, int level) {
        if (head == null) return;
        levelSum[level] += head.val;
        calcLevelSum(head.left, level + 1);
        calcLevelSum(head.right, level + 1);
    }

    void replaceValue(TreeNode head, int level) {
        if (head == null) return;
        int cur = getVal(head.left) + getVal(head.right);
        int nextVal = levelSum[level + 1] - cur;
        if (head.left != null) {
            head.left.val = nextVal;
            replaceValue(head.left, level + 1);
        }
        if (head.right != null) {
            head.right.val = nextVal;
            replaceValue(head.right, level + 1);
        }
    }

    int getVal(TreeNode cur) {
        return cur == null ? 0 : cur.val;
    }
}