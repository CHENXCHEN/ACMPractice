package leetcode.normal.j2364;

import java.util.HashMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-number-of-bad-pairs/description/">2364. 统计坏数对的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long countBadPairs(int[] nums) {
        // i < j，找到 j - i != nums[j] - nums[i]
        // 等价于 j - nums[j] != i - nums[i]
        HashMap<Integer, Integer> cnt = new HashMap<>();
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += i - cnt.getOrDefault(i - nums[i], 0);
            cnt.compute(i - nums[i], (k, v) -> v == null ? 1 : v + 1);
        }
        return ans;
    }
}