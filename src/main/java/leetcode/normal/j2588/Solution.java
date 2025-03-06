package leetcode.normal.j2588;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-the-number-of-beautiful-subarrays/description/">2588. 统计美丽子数组数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long beautifulSubarrays(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        long ans = 0;
        int mask = 0;
        cnt.put(0, 1);
        for (int num : nums) {
            mask ^= num;
            ans += cnt.getOrDefault(mask, 0);
            cnt.put(mask, cnt.getOrDefault(mask, 0) + 1);
        }
        return ans;
    }
}