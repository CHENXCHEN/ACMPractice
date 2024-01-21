package leetcode.normal.j2809;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-time-to-make-array-sum-at-most-x/description/">2809. 使数组和小于等于 x 的最少时间</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int n = nums1.size();
        Integer[] pos = new Integer[n];
        for (int i = 0; i < n; i++) pos[i] = i;
        Arrays.sort(pos, Comparator.comparingInt(nums2::get));
        // dp[i] -> 表示进行 i 次操作之后，能删减的最大值是多少？
        int[] dp = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            for (int i = j; i > 0; i--) {
                dp[i] = Math.max(dp[i], dp[i - 1] + nums1.get(pos[j - 1]) + nums2.get(pos[j - 1]) * i);
            }
        }
        int s1 = 0, s2 = 0;
        for (int i = 0; i < n; i++) {
            s1 += nums1.get(i);
            s2 += nums2.get(i);
        }
        for (int i = 0; i <= n; i++) {
            if (s2 * i + s1 - dp[i] <= x) return i;
        }
        return -1;
    }
}
