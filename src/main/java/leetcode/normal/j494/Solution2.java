package leetcode.normal.j494;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/target-sum/
 * 494. 目标和
 * DP
 * (sum - neg) - neg = target
 * sum - target = 2 * neg
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution2 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int neg2 = sum - target;
        if (neg2 < 0 || neg2 % 2 != 0) return 0;
        int neg = neg2 >> 1;
        int[] dp = new int[neg + 10];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = neg; j >= 0; j--) {
                if (j >= num) dp[j] += dp[j - num];
            }
        }
        return dp[neg];
    }
}
