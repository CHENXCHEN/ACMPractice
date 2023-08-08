package leetcode.normal.j1749;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-absolute-sum-of-any-subarray/">1749. 任意子数组和的绝对值的最大值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int maxAbsoluteSum(int[] nums) {
        // 求连续子数组中绝对值的最大值 = 最大的前缀和 - 最小的前缀和
        int cur = 0, max = 0, min = 0;
        for (int num : nums) {
            cur += num;
            max = Math.max(max, cur);
            min = Math.min(min, cur);
        }
        return max - min;
    }
}