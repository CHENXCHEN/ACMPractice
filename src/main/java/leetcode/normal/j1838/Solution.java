package leetcode.normal.j1838;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element/
 * 1838. 最高频元素的频数
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long[] preSum = new long[nums.length + 1];
        int len = nums.length;
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        if ((long) len * nums[len - 1] - preSum[len] <= k) {
            return len;
        } else {
            int ans = 1;
            for (int i = 1; i < len; i++) {
                int left = findLeftLessThan(nums, preSum, k, i);
                if (left != -1) ans = Math.max(ans, i - left + 1);
            }
            return ans;
        }
    }

    int findLeftLessThan(int[] nums, long[] preSum, int k, int right) {
        int l = 0, r = right, ret = -1;
        while (l <= r) {
            int m = (l + r) >> 1;
            long vSum = (long) (right - m + 1) * nums[right];
            if (vSum - (preSum[right + 1] - preSum[m]) <= k) {
                ret = m;
                r = m - 1;
            } else l = m + 1;
        }
        return ret;
    }
}
