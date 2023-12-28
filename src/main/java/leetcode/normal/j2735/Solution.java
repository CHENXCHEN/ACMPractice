package leetcode.normal.j2735;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/collecting-chocolates/description/">2735. 收集巧克力</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long minCost(int[] nums, int x) {
        long ans = getSum(nums);
        int n = nums.length;
        int[] f = new int[n];
        System.arraycopy(nums, 0, f, 0, n);
        for (int k = 1; k < n; k++) {
            for (int i = 0; i < n; i++) {
                f[i] = Math.min(f[i], nums[(i + k) % n]);
            }
            ans = Math.min(ans, (long) k * x + getSum(f));
        }
        return ans;
    }

    long getSum(int[] dp) {
        long ans = 0;
        for (int num : dp) {
            ans += num;
        }
        return ans;
    }
}