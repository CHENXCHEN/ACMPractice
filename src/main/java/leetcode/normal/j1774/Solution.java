package leetcode.normal.j1774;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/closest-dessert-cost/">1774. 最接近目标价格的甜点成本</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int min = Arrays.stream(baseCosts).min().getAsInt();
        if (min >= target) return min;
        boolean[] dp = new boolean[target + 1];
        int res = (target << 1) - min;
        for (int baseCost : baseCosts) {
            if (baseCost < target) dp[baseCost] = true;
            else res = Math.min(res, baseCost);
        }

        for (int toppingCost : toppingCosts) {
            for (int k = 0; k < 2; k++) {
                for (int v = target; v > 0; v--) {
                    if (dp[v] && v + toppingCost > target) {
                        res = Math.min(res, v + toppingCost);
                    }
                    if (v - toppingCost > 0)
                        dp[v] |= dp[v - toppingCost];
                }
            }
        }
        for (int i = 0; i <= res - target; i++) {
            if (dp[target - i]) return target - i;
        }
        return res;
    }
}