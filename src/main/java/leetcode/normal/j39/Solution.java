package leetcode.normal.j39;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/combination-sum/description/">39. 组合总和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] candidates;
    ArrayList<List<Integer>> ans;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        ans = new ArrayList<>();
        dfs(target, new ArrayList<>(), 0);
        return ans;
    }

    void dfs(int target, ArrayList<Integer> combine, int idx) {
        if (target < 0) return;
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                combine.add(candidates[i]);
                dfs(target - candidates[i], combine, i);
                combine.remove(combine.size() - 1);
            }
        }
    }
}