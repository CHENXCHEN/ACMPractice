package leetcode.normal.j2562;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/successor-lcci/
 * 面试题 04.06. 后继者
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    TreeNode lastAccess;
    TreeNode ans;
    TreeNode needFind;

    void midTravel(TreeNode root) {
        if (root == null) return;
        midTravel(root.left);
        if (lastAccess == needFind) {
            ans = root;
        }
        lastAccess = root;
        midTravel(root.right);
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        ans = lastAccess = null;
        needFind = p;
        midTravel(root);
        return ans;
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}