package leetcode.normal.j2616;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimize-the-maximum-difference-of-pairs/description/">2616. 最小化数对的最大差值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimizeMax(int[] nums, int p) {
        if (p == 0) return 0;
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1] - nums[0];
        int ans = right;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int count = 0;
            for (int i = 0; i < nums.length - 1; ) {
                if (nums[i + 1] - nums[i] <= mid) {
                    count++;
                    i += 2;
                } else i++;
            }
            if (count >= p) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}