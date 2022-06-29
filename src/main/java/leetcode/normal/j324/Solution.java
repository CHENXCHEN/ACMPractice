package leetcode.normal.j324;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/wiggle-sort-ii/
 * 324. 摆动排序 II
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int bound = (n + 1) >> 1;
        int[] ans = new int[n];
        for (int leftPos = bound - 1, i = 0, rightPos = n - 1; i < n; leftPos--, rightPos--, i += 2) {
            ans[i] = nums[leftPos];
            if (i + 1 < nums.length) {
                ans[i + 1] = nums[rightPos];
            }
        }
        System.arraycopy(ans, 0, nums, 0, nums.length);
    }
}
// 0,1,2,3,4,5,6
// 0,4,1,5,2,6,3

// 0,1,2,3,4,5
// 0,4,1,5,2,3

// [4,5,5,6]
// [5,6,4,5]

// 3,4,5,5,6,6
// 3,5,4,6,5,6

