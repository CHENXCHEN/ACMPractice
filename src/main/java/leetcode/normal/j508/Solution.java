package leetcode.normal.j508;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/most-frequent-subtree-sum/
 * 508. 出现次数最多的子树元素和
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    TreeMap<Integer, Integer> tMap = new TreeMap<>();
    ArrayList<Integer> arr = new ArrayList<>();
    int maxCnt = 0;

    int dfs(TreeNode root) {
        if (root == null) return 0;
        int now = root.val + dfs(root.left) + dfs(root.right);
        int nowCnt = tMap.getOrDefault(now, 0) + 1;
        tMap.put(now, nowCnt);
        if (nowCnt >= maxCnt) {
            if (nowCnt > maxCnt) arr.clear();
            arr.add(now);
            maxCnt = nowCnt;
        }
        return now;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        for (Integer value : tMap.values()) {
            maxCnt = Math.max(value, maxCnt);
        }
        int[] ans = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) ans[i] = arr.get(i);
        return ans;
    }
}