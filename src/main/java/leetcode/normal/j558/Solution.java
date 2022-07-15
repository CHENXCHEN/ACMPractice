package leetcode.normal.j558;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/logical-or-of-two-binary-grids-represented-as-quad-trees/">558. 四叉树交集</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf) {
            if (quadTree1.val) return new Node(true, true, null, null, null, null);
            return quadTree2;
        } else if (quadTree2.isLeaf) {
            return intersect(quadTree2, quadTree1);
        }
        Node topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        Node bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        if (topLeft.isLeaf & topRight.isLeaf & bottomLeft.isLeaf & bottomRight.isLeaf & (topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val)) {
            return new Node(true, topLeft.val, null, null, null, null);
        }
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}