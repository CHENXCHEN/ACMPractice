package leetcode.normal.j1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/two-sum/">1. 两数之和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = {0, 0};
        for (int i = 0; i < nums.length; i++) {
            Integer pos = map.get(target - nums[i]);
            if (pos != null) {
                ans[0] = pos;
                ans[1] = i;
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}