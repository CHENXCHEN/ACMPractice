package leetcode.normal.j2799;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-complete-subarrays-in-an-array/description/">2799. 统计完全子数组的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int countCompleteSubarrays(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int need = new HashSet<>(Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new))).size();
        int ans = 0;
        int n = nums.length;
        for (int i = 0, j = 0; i < n; i++) {
            while (j < n && map.size() < need) {
                map.compute(nums[j], (k, v) -> v == null ? 1 : v + 1);
                j++;
            }
            if (map.size() == need) {
                ans += n - j + 1;
            }
            map.compute(nums[i], (k, v) -> v == 1 ? null : v - 1);
        }
        return ans;
    }
}