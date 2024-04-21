package leetcode.normal.j216;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/combination-sum-iii/description/">216. 组合总和 III</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    ArrayList<List<Integer>> ans;
    int k;

    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        this.k = k;
        dfs(0, n, new ArrayList<>());
        return ans;
    }

    void dfs(int idx, int left, ArrayList<Integer> res) {
        if (res.size() == k) {
            if (left == 0) ans.add(new ArrayList<>(res));
            return;
        }
        for (int i = idx + 1; i <= 9; i++) {
            if (left - i >= 0) {
                res.add(i);
                dfs(i, left - i, res);
                res.remove(res.size() - 1);
            }
        }
    }
}