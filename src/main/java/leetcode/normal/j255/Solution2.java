package leetcode.normal.j255;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/verify-preorder-sequence-in-binary-search-tree/description/">255. 验证二叉搜索树的前序遍历序列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public boolean verifyPreorder(int[] preorder) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        // min 是右节点的父节点的值，表示比右节点小的节点必须要大于 min，否则不构成二叉搜索树
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < preorder.length; i++) {
            int num = preorder[i];
            // 如果当前节点值小于上一个右节点的父节点，那么一定不合法
            if (num <= min) return false;
            while (!stack.isEmpty() && num > stack.peek()) {
                min = stack.pop();
            }
            stack.push(num);
        }
        return true;
    }
}
