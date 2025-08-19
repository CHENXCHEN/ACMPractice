package leetcode.normal.j2348;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-zero-filled-subarrays/description/">2348. 全 0 子数组的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                ++cnt;
            } else {
                ans += (1 + cnt) * cnt / 2;
                cnt = 0;
            }
        }
        ans += (1 + cnt) * cnt / 2;
        return ans;
    }
}