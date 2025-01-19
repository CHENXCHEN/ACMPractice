package leetcode.normal.j3287;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-maximum-sequence-value-of-array/description/">3287. 求出数组中最大序列值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxValue(int[] nums, int k) {
        List<Set<Integer>> A = findORs(nums, k);
        List<Set<Integer>> B = findORs(reverse(nums), k);
        int ans = 0;
        // 至少保证左边子数组要有 k 个，并且右边子数组要有 k 个
        for (int i = k - 1; i < nums.length - k; i++) {
            for (int a : A.get(i)) {
                // n - 1 - (i + 1) => n - i - 2
                for (int b : B.get(nums.length - i - 2)) {
                    ans = Math.max(ans, a ^ b);
                }
            }
        }
        return ans;
    }

    List<Set<Integer>> findORs(int[] nums, int k) {
        // dp[i][j] 表示 nums[0...i] 中选择不超过 j 位数按位或的所有可能值
        // dp[i][j] = dp[i-1][j] + (dp[i-1][j-1] | nums[i])
        List<Set<Integer>> dp = new ArrayList<>();
        // 考虑到只需要维护上一轮的结果，所以可以状态优化，将 dp[..][0...j] 的第二维提取出来，累计维护
        // 对于枚举到的位置 i 来说，prev 表示的是 dp[i-1][0..j]，即 pre[j] = dp[i-1][j]
        // 因此对于位置 i，pre[j] ++= pre[j-1] | nums[i]
        List<Set<Integer>> prev = new ArrayList<>();
        for (int i = 0; i <= k; i++) prev.add(new HashSet<>());
        prev.get(0).add(0);
        for (int i = 0; i < nums.length; i++) {
            // 对于每个位置，不能选择超过 k 个数字，注意 j 由 j-1 转移得，每个元素只能选择一次，因此要从大到小枚举
            for (int j = Math.min(k - 1, i + 1); j >= 0; j--) {
                for (Integer x : prev.get(j)) {
                    prev.get(j + 1).add(nums[i] | x);
                }
            }
            dp.add(new HashSet<>(prev.get(k)));
        }
        return dp;
    }

    int[] reverse(int[] nums) {
        int[] reversed = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            reversed[i] = nums[nums.length - 1 - i];
        }
        return reversed;
    }
}