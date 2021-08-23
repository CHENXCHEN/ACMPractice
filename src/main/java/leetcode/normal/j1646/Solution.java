package leetcode.normal.j1646;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/get-maximum-in-generated-array/
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int getMaximumGenerated(int n) {
        if (n == 0) return 0;
        int[] nums = new int[n + 2];
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 1; i <= n; i++) {
            int ll = i << 1;
            int rr = ll | 1;
            if (ll <= n) nums[ll] = nums[i];
            else break;
            if (rr <= n) nums[rr] = nums[i] + nums[i + 1];
            else break;
        }
        int ans = 1;
        for (int i = 2; i <= n; i++) {
            if (ans < nums[i]) ans = nums[i];
        }
        return ans;
    }
}