package leetcode.normal.j652;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-duplicate-subtrees/">652. 寻找重复的子树</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    HashSet<TreeNode> tSet = new HashSet<>();
    HashMap<String, Pair<TreeNode, Integer>> seen = new HashMap<>();
    int idx = 0;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<>(tSet);
    }

    int dfs(TreeNode root) {
        if (root == null) return 0;
        int[] hArr = {root.val, dfs(root.left), dfs(root.right)};
        String hStr = Arrays.toString(hArr);
        Pair<TreeNode, Integer> seeRet = seen.get(hStr);
        if (seeRet != null) {
            tSet.add(seeRet.getKey());
            return seeRet.getValue();
        } else {
            seen.put(hStr, new Pair<>(root, ++idx));
            return idx;
        }
    }
}