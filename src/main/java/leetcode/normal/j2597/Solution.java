package leetcode.normal.j2597;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/the-number-of-beautiful-subsets/description/">2597. 美丽子集的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] nums;
    int ans, k;
    Map<Integer, Integer> cnt;

    public int beautifulSubsets(int[] nums, int k) {
        this.k = k;
        this.nums = nums;
        int n = nums.length;
        cnt = new HashMap<>();
        ans = 0;
        dfs(0);
        return ans - 1;
    }

    void dfs(int idx) {
        if (idx == nums.length) {
            ++ans;
            return;
        }
        // 如果不选
        dfs(idx + 1);
        // 如果选
        if (!cnt.containsKey(nums[idx] - k) && !cnt.containsKey(nums[idx] + k)) {
            cnt.compute(nums[idx], (key, value) -> value == null ? 1 : value + 1);
            dfs(idx + 1);
            cnt.compute(nums[idx], (key, value) -> value == null || value == 1 ? null : value - 1);
        }
    }

}