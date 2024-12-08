package leetcode.normal.j510;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/inorder-successor-in-bst-ii/description/">510. 二叉搜索树中的中序后继 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public Node inorderSuccessor(Node node) {
        Node cur = node;
        // 如果有右节点，先判断右节点，包括了可能是根节点的情况
        if (cur.right != null) {
            // 如果有右节点，那么找右节点的子孙最小的那个
            cur = cur.right;
            while (cur.left != null) cur = cur.left;
            return cur;
        }
        // 如果没有右节点，那么找大于它的父节点
        // 如果有父节点，那么找到第一个符合情况的父节点，如果当前是右节点，那么继续往上找父节点
        while (cur.parent != null && cur.val > cur.parent.val) cur = cur.parent;
        // 如果找到根节点也没有的话，那么说明当前节点已经是右节点往上找的，一定不存在答案
        return cur.parent;
    }
}