package leetcode.normal.j3181;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-total-reward-using-operations-ii/description/">3181. 执行操作可获得的最大总奖励 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int n = rewardValues.length;
        if (n >= 2 && rewardValues[n - 2] == rewardValues[n - 1] - 1) {
            return 2 * rewardValues[n - 1] - 1;
        }
        // 参考 dp[k'] = dp[k'] | dp[k' - x]， 观察可得，是将 dp[0,...,x-1] 这部分，按或作用于 dp[x,....,2*x-1] 上
        BigInteger bitmap = BigInteger.ONE;
        for (int i = 0; i < n; i++) {
            if (i == 0 || rewardValues[i] != rewardValues[i - 1]) {
                int rewardValue = rewardValues[i];
                BigInteger mask = BigInteger.ONE.shiftLeft(rewardValue).subtract(BigInteger.ONE);
                bitmap = bitmap.or(bitmap.and(mask).shiftLeft(rewardValue));
            }
        }
        return bitmap.bitLength() - 1;
    }
}