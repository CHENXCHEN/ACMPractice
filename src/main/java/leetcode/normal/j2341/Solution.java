package leetcode.normal.j2341;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-number-of-pairs-in-array/">2341. 数组能形成多少数对</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] numberOfPairs(int[] nums) {
        int[] has = new int[101];
        for (int num : nums) {
            has[num]++;
        }
        int[] ans = new int[2];
        for (int i = 0; i <= 100; i++) {
            ans[0] += has[i] >> 1;
            ans[1] += has[i] & 1;
        }
        return ans;
    }
}