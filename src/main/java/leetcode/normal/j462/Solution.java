package leetcode.normal.j462;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/
 * 462. 最少移动次数使数组元素相等 II
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int left = nums[0], right = nums[nums.length - 1];
        long ans = Long.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) >> 1;
            long midMoves = minMoves(nums, mid);
            int leftMid = (mid + left) >> 1;
            long leftMidMoves = minMoves(nums, leftMid);
            if (midMoves <= leftMidMoves) {
                ans = Math.min(ans, midMoves);
                left = leftMid + 1;
            } else {
                ans = Math.min(ans, leftMidMoves);
                right = mid - 1;
            }
        }
        return (int) ans;
    }

    long minMoves(int[] nums, int mid) {
        long cnt = 0;
        for (int num : nums) cnt += Math.abs(num - mid);
        return cnt;
    }
}