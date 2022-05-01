package leetcode.normal.j1305;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/
 * 1305. 两棵二叉搜索树中的所有元素
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    void midTreeTravel(TreeNode root, ArrayList<Integer> ans) {
        if (root == null) return;
        if (root.left != null) midTreeTravel(root.left, ans);
        ans.add(root.val);
        if (root.right != null) midTreeTravel(root.right, ans);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> arr1 = new ArrayList<>(), arr2 = new ArrayList<>(), ans = new ArrayList<>();
        midTreeTravel(root1, arr1);
        midTreeTravel(root2, arr2);
        int pos1 = 0, pos2 = 0;
        while (pos1 < arr1.size() || pos2 < arr2.size()) {
            if (pos1 < arr1.size() && pos2 < arr2.size()) {
                if (arr1.get(pos1) <= arr2.get(pos2)) {
                    ans.add(arr1.get(pos1));
                    pos1++;
                } else {
                    ans.add(arr2.get(pos2));
                    pos2++;
                }
            } else if (pos1 < arr1.size()) {
                ans.add(arr1.get(pos1));
                pos1++;
            } else {
                ans.add(arr2.get(pos2));
                pos2++;
            }
        }
        return ans;
    }
}