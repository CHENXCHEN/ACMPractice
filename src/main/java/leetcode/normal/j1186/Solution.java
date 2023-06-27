package leetcode.normal.j1186;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-subarray-sum-with-one-deletion/">1186. 删除一次得到子数组最大和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maximumSum(int[] arr) {
        // dp0 代表到当前元素为止，不删除元素的最大和是多少
        // dp1 代表到当前元素为止，删除1个元素的最大和是多少
        int dp0 = arr[0], dp1 = 0, res = dp0;
        for (int i = 1; i < arr.length; i++) {
            // 当前删除 1 个元素的最大和为，不选择或者选择 这两种情况下的最大值
            dp1 = Math.max(dp0, dp1 + arr[i]);
            // 当前不删除元素的最大和为，要不要之前的数
            dp0 = Math.max(dp0, 0) + arr[i];
            res = Math.max(res, Math.max(dp0, dp1));
        }
        return res;
    }
}