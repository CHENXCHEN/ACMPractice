package leetcode.normal.j410;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/split-array-largest-sum/description/">410. 分割数组的最大值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution2 {
    public int splitArray(int[] nums, int k) {
        int left = Arrays.stream(nums).max().getAsInt(), right = Arrays.stream(nums).sum(), ans = right;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (check(nums, mid, k)) {
                ans = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return ans;
    }

    boolean check(int[] nums, int limit, int k) {
        int cnt = 1, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > limit) {
                sum = nums[i];
                ++cnt;
            } else {
                sum += nums[i];
            }
        }
        return cnt <= k;
    }
}
