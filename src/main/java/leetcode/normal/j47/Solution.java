package leetcode.normal.j47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/permutations-ii/description/">47. 全排列 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    boolean[] vis;
    List<List<Integer>> ans;
    int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        vis = new boolean[nums.length];
        ans = new ArrayList<>();
        Arrays.sort(nums);
        solve(0, new ArrayList<>());
        return ans;
    }

    void solve(int idx, List<Integer> res) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(res));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 如果是相邻相同的元素，必须要保证前一个已经被选取，否则可能会重复
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) continue;
            res.add(nums[i]);
            vis[i] = true;
            solve(idx + 1, res);
            vis[i] = false;
            res.remove(res.size() - 1);
        }
    }
}