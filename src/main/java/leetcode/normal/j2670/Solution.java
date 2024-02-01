package leetcode.normal.j2670;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-distinct-difference-array/description/">2670. 找出不同元素数目差数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] leftCnt = new int[n], rightCnt = new int[n];
        long mark = 0L;
        leftCnt[0] = 1;
        mark = 1L << nums[0];
        for (int i = 1; i < n; i++) {
            long cur = 1L << nums[i];
            leftCnt[i] = leftCnt[i - 1];
            if ((mark & cur) == 0) {
                ++leftCnt[i];
                mark |= cur;
            }
        }
        mark = 1L << nums[n - 1];
        rightCnt[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            long cur = 1L << nums[i];
            rightCnt[i] = rightCnt[i + 1];
            if ((mark & cur) == 0) {
                ++rightCnt[i];
                mark |= cur;
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == n - 1) ans[i] = leftCnt[i];
            else ans[i] = leftCnt[i] - rightCnt[i + 1];
        }
        return ans;
    }
}