package leetcode.normal.j805;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/split-array-with-same-average/">805. 数组的均值分割</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        // sum(A) / k = sum(B) / (n-k)
        // => sum(A) * n - sum(A) * k = sum(B) * k
        // => sum(A) * n = k * (sum(A) + sum(B))
        // => sum(A) * n = k * sum(nums)
        // 动态规划，求从数组中选 k 个作为 A，是否可以凑成 sum(A) = k * sum(nums) / n
        // dp[i][j] 为 选择 i 个数字，是否能凑成 j
        // dp[i][x+nums[j]] = dp[i-1][x]
        if (nums.length == 1) return false;
        int sum = Arrays.stream(nums).sum();
        int n = nums.length, m = n >> 1;
        boolean isPossible = false;
        for (int i = m; i > 0; i--) {
            if (sum * i % n == 0) {
                isPossible = true;
                break;
            }
        }
        if (!isPossible) return false;
        Set<Integer>[] dp = new Set[m + 1];
        for (int i = 0; i <= m; i++) dp[i] = new HashSet<>();
        dp[0].add(0);
        for (int num : nums) {
            for (int i = m; i > 0; i--) {
                for (int item : dp[i - 1]) {
                    int cur = item + num;
                    if (cur * n == sum * i) return true;
                    dp[i].add(cur);
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {6, 8, 18, 3, 1};
        System.out.println(solution.splitArraySameAverage(nums));
    }
}