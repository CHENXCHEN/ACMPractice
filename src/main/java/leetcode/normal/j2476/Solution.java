package leetcode.normal.j2476;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/closest-nodes-queries-in-a-binary-search-tree/description/">2476. 二叉搜索树最近节点查询</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> inOrder = new ArrayList<>();
        listInOrder(root, inOrder);
        for (Integer query : queries) {
            int idx = Collections.binarySearch(inOrder, query);
            if (idx >= 0) {
                ans.add(Arrays.asList(query, query));
            } else {
                idx = -idx - 1;
                int v1 = -1, v2 = -1;
                if (idx - 1 >= 0) {
                    v1 = inOrder.get(idx - 1);
                }
                if (idx < inOrder.size()) {
                    v2 = inOrder.get(idx);
                }
                ans.add(Arrays.asList(v1, v2));
            }
        }
        return ans;
    }

    void listInOrder(TreeNode root, ArrayList<Integer> inOrder) {
        if (root == null) return;
        listInOrder(root.left, inOrder);
        inOrder.add(root.val);
        listInOrder(root.right, inOrder);
    }
}