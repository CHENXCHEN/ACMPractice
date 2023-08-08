package leetcode.normal.j1749;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-absolute-sum-of-any-subarray/">1749. 任意子数组和的绝对值的最大值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        // cur0 => 记录到目前为止的最大连续和 >=0 的值
        // cur1 => 记录到目前为止的最大连续和 <=0 的值
        int ans = 0, cur0 = 0, cur1 = 0;
        for (int num : nums) {
            if (cur0 < 0) cur0 = 0;
            if (cur1 > 0) cur1 = 0;
            cur0 += num;
            cur1 += num;
            ans = Math.max(ans, Math.max(cur0, -cur1));
        }
        return ans;
    }
}