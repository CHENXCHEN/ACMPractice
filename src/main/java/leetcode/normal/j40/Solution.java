package leetcode.normal.j40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/combination-sum-ii/description/">40. 组合总和 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    ArrayList<int[]> freq;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        freq = new ArrayList<>();
        freq.add(new int[]{candidates[0], 1});
        for (int i = 1; i < candidates.length; i++) {
            if (candidates[i] == freq.get(freq.size() - 1)[0]) {
                freq.get(freq.size() - 1)[1] += 1;
            } else {
                freq.add(new int[]{candidates[i], 1});
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(target, 0, new ArrayList<>(), result);
        return result;
    }

    void dfs(int left, int idx, ArrayList<Integer> list, List<List<Integer>> ans) {
        if (left == 0) {
            String string = list.toString();
            ans.add(new ArrayList<>(list));
            return;
        }
        if (idx >= freq.size() || left < 0) return;
        dfs(left, idx + 1, list, ans);
        int most = Math.min(left / freq.get(idx)[0], freq.get(idx)[1]);
        for (int i = 1; i <= most; i++) {
            list.add(freq.get(idx)[0]);
            dfs(left - i * freq.get(idx)[0], idx + 1, list, ans);
        }
        for (int i = 1; i <= most; i++) {
            list.remove(list.size() - 1);
        }
    }
}