package leetcode.normal.j2831;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-longest-equal-subarray/description/">2831. 找出最长等值子数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int n = nums.size();
        Map<Integer, List<Integer>> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.computeIfAbsent(nums.get(i), x -> new ArrayList<>()).add(i);
        }
        int ans = 0;
        for (List<Integer> res : pos.values()) {
            for (int i = 0, j = 0; i < res.size(); i++) {
                // res[i] - res[j] 为这个区间的长度
                // i - j 为这个区间内，这个数字的个数
                // res[i] - res[j] - (i - j) 为这个区间内与这个数不同的数目
                while (res.get(i) - res.get(j) - (i - j) > k) {
                    ++j;
                }
                ans = Math.max(ans, i - j + 1);
            }
        }
        return ans;
    }
}