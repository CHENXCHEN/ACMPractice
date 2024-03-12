package leetcode.normal.j1261;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-elements-in-a-contaminated-binary-tree/description/">1261. 在受污染的二叉树中查找元素</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class FindElements {
    TreeNode root;

    public FindElements(TreeNode root) {
        this.root = root;
        recover(root, 0);
    }

    public boolean find(int target) {
        return findTree(root, target);
    }

    boolean findTree(TreeNode head, int target) {
        if (head == null) return false;
        if (target == head.val) return true;
        if (head.val > target) return false;
        return findTree(head.left, target) || findTree(head.right, target);
    }

    void recover(TreeNode head, int vv) {
        if (head == null) return;
        head.val = vv;
        recover(head.left, (vv << 1) + 1);
        recover(head.right, (vv << 1) + 2);
    }
}