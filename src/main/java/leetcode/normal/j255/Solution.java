package leetcode.normal.j255;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/verify-preorder-sequence-in-binary-search-tree/description/">255. 验证二叉搜索树的前序遍历序列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean verifyPreorder(int[] preorder) {
        return dfs(preorder, 0, preorder.length - 1);
    }

    boolean dfs(int[] preorder, int start, int end) {
        if (end - start < 2) return true;
        ArrayList<Integer> idx = new ArrayList<>();
        boolean check = true;
        // 从排列上找规律，对于二叉搜索树的先序遍历来说
        // 如果存在 preorder[x] < preorder[y]，那么对于 k > y，必然有 preorder[k] > preorder[x] 成立
        //      因为 k > y 的节点，一定是 x 的右子树，必须要比 x 大
        // 对于 (x, y)，一定是 x 的左子树，一定比 x 小
        for (int i = start; i <= end && check; i++) {
            if (idx.size() >= 2 && preorder[i] < preorder[idx.get(idx.size() - 2)]) {
                check = false;
                break;
            }
            if (idx.isEmpty()) idx.add(i);
            else if (preorder[i] > preorder[idx.get(idx.size() - 1)]) {
                idx.add(i);
                check = dfs(preorder, idx.get(idx.size() - 2) + 1, i - 1);
            }
        }
        // 走完之后，再对最后一个区间做判断
        check &= dfs(preorder, idx.get(idx.size() - 1) + 1, end);
        return check;
    }
}