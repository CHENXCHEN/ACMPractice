package leetcode.normal.j3180;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-total-reward-using-operations-i/description/">3180. 执行操作可获得的最大总奖励 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int maxReward = rewardValues[rewardValues.length - 1];
        // dp[i] 表示奖励为 i 是否能组成
        // 如果选择的最后一个元素是 x，那么之前的总奖励 k, 一定满足 k < x
        // 对于最终新的奖励 k' 满足 x <= k' < 2 * x
        // dp[k'] = dp[k'] | dp[k' - x]
        boolean[] dp = new boolean[maxReward << 1];
        dp[0] = true;
        for (int rewardValue : rewardValues) {
            for (int k = rewardValue * 2 - 1; k >= rewardValue; k--) {
                dp[k] |= dp[k - rewardValue];
            }
        }
        int ans = 0;
        for (int i = dp.length - 1; i > 0 && ans == 0; i--) {
            if (dp[i]) ans = i;
        }
        return ans;
    }
}