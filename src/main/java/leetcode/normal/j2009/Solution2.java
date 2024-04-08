package leetcode.normal.j2009;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-number-of-operations-to-make-array-continuous/description/">2009. 使数组连续的最少操作数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int[] res = new int[n + 1];
        Arrays.sort(nums);
        res[++res[0]] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) res[++res[0]] = nums[i];
        }
        int ans = n - 1;
        for (int i = 1, j = 1; i <= res[0]; i++) {
            int right = res[i] + n - 1;
            while (j <= res[0] && res[j] <= right) {
                ++j;
            }
            ans = Math.min(ans, n - (j - i));
        }
        return ans;
    }
}