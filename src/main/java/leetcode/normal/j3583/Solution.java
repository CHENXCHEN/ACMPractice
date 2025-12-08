package leetcode.normal.j3583;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-special-triplets/description/">3583. 统计特殊三元组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int specialTriplets(int[] nums) {
        int MOD = (int) 1e9 + 7;
        Map<Integer, Integer> numAllCnt = new HashMap<>();
        Map<Integer, Integer> numCnt = new HashMap<>();
        for (int num : nums) {
            numAllCnt.compute(num, (kk, vv) -> vv == null ? 1 : (vv + 1));
        }
        long ans = 0;
        // 枚举中间值，统计中间值左边的出现数与右边的出现数
        // 右边出现数 = 总共出现 - 左边出现的(包括当前位置)
        for (int num : nums) {
            int target = num << 1;
            int leftCnt = numCnt.getOrDefault(target, 0);
            numCnt.compute(num, (kk, vv) -> vv == null ? 1 : (vv + 1));
            int rightCnt = numAllCnt.getOrDefault(target, 0) - numCnt.getOrDefault(target, 0);
            ans = (ans + (long) leftCnt * rightCnt) % MOD;
        }
        return (int) ans;
    }
}