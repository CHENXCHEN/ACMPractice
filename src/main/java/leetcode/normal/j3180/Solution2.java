package leetcode.normal.j3180;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-total-reward-using-operations-i/description/">3180. 执行操作可获得的最大总奖励 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        // 参考 dp[k'] = dp[k'] | dp[k' - x]， 观察可得，是将 dp[0,...,x-1] 这部分，按或作用于 dp[x,....,2*x-1] 上
        BigInteger bitmap = BigInteger.ONE;
        for (int rewardValue : rewardValues) {
            BigInteger mask = BigInteger.ONE.shiftLeft(rewardValue).subtract(BigInteger.ONE);
            bitmap = bitmap.or(bitmap.and(mask).shiftLeft(rewardValue));
        }
        return bitmap.bitLength() - 1;
    }
}