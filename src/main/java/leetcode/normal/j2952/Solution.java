package leetcode.normal.j2952;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-number-of-coins-to-be-added/description/">2952. 需要添加的硬币的最小数量</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        // last -> 最小的不可组成的值
        int last = 1, ans = 0, idx = 0, n = coins.length;
        while (last <= target) {
            if (idx < n && coins[idx] <= last) {
                // 如果当前硬币值小于等于不可组成的值
                last += coins[idx++];
            } else {
                // 如果当前硬币值不存在，那么就要添加硬币了
                last <<= 1;
                ans++;
            }
        }
        return ans;
    }
}