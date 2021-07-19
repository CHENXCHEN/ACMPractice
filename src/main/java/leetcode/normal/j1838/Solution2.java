package leetcode.normal.j1838;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element/
 * 1838. 最高频元素的频数
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution2 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1, l = 0, tot = 0;
        for (int r = 1; r < nums.length; r++) {
            tot += (nums[r] - nums[r - 1]) * (r - l);
            while (tot > k) {
                tot -= nums[r] - nums[l];
                ++l;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
