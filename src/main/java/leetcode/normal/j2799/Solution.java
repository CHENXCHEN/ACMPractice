package leetcode.normal.j2799;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-complete-subarrays-in-an-array/description/">2799. 统计完全子数组的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.compute(num, (k, v) -> v == null ? 1 : v + 1);
        }
        int need = map.size(), ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            int j = i;
            while (j < n && set.size() < need) {
                set.add(nums[j++]);
            }
            if (set.size() == need) {
                ans += n - j + 1;
            }
            map.compute(nums[i], (k, v) -> v == 1 ? null : v - 1);
            if (map.size() < need) break;
        }
        return ans;
    }
}