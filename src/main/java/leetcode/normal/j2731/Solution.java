package leetcode.normal.j2731;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/movement-of-robots/description/">2731. 移动机器人</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int sumDistance(int[] nums, String s, int d) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                nums[i] += d;
            } else nums[i] -= d;
        }
        Arrays.sort(nums);
        long sum = nums[0];
        long ans = 0, mod = (long) (1e9 + 7);
        for (int i = 1; i < nums.length; i++) {
            ans = (ans + (long) i * nums[i] - sum) % mod;
            sum = (sum + nums[i]) % mod;
        }
        ans = (ans + mod) % mod;
        return (int) ans;
    }
}