package leetcode.normal.j894;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/all-possible-full-binary-trees/description/">894. 所有可能的真二叉树</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if (n % 2 == 0) return ans;
        if (n == 1) {
            ans.add(new TreeNode());
            return ans;
        }
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> leftChildren = allPossibleFBT(i), rightChildren = allPossibleFBT(n - 1 - i);
            for (TreeNode leftChild : leftChildren) {
                for (TreeNode rightChild : rightChildren) {
                    ans.add(new TreeNode(0, leftChild, rightChild));
                }
            }
        }
        return ans;
    }
}