package leetcode.normal.j2560;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/house-robber-iv/description/">2560. 打家劫舍 IV</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] nums;

    public int minCapability(int[] nums, int k) {
        this.nums = nums;
        int left = Arrays.stream(nums).min().getAsInt(), right = Arrays.stream(nums).max().getAsInt(), ans = right;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (check(mid, k)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    boolean check(int max, int k) {
        int last = -2;
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] <= max && i - last > 1) {
                last = i;
                --k;
            }
        }
        return k == 0;
    }
}