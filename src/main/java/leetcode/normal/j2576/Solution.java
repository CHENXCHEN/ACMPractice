package leetcode.normal.j2576;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-maximum-number-of-marked-indices/description/">2576. 求出最多标记下标</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, r = n >> 1, ans = 0;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (check(nums, mid)) {
                ans = mid;
                l = mid + 1;
            } else r = mid - 1;
        }
        return ans << 1;
    }

    boolean check(int[] nums, int m) {
        int n = nums.length;
        for (int i = 0; i < m; i++) {
            if (nums[i] * 2 > nums[n - m + i]) return false;
        }
        return true;
    }
}