package leetcode.normal.j2845;

import java.util.HashMap;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-of-interesting-subarrays/description/">2845. 统计趣味子数组的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        // 题目要求满足 [l,r] 中 nums[i] % modulo = k 的数量 cnt, cnt % modulo = k 的 [l,r] 数目
        // 设 sum[r] 表示为 nums[0...r] % modulo = k 的数目，设当前为 r 时，我们需要满足 (sum[r] - sum[l-1]) % modulo = k
        // 变换等式，得：(sum[r] - k + modulo) % modulo = sum[l-1] % modulo
        // 然后在枚举 r 的过程中维护 sum[i] % modulo 的计数，最后累加即可
        int n = nums.size();
        HashMap<Integer, Integer> cnt = new HashMap<>();
        long ans = 0;
        int prefix = 0;
        cnt.put(0, 1);
        for (int i = 0; i < n; i++) {
            prefix += nums.get(i) % modulo == k ? 1 : 0;
            ans += cnt.getOrDefault((prefix - k + modulo) % modulo, 0);
            cnt.compute(prefix % modulo, (kk, vv) -> vv == null ? 1 : vv + 1);
        }
        return ans;
    }
}