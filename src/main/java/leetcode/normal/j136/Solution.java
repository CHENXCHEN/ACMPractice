package leetcode.normal.j136;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/single-number/description/
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}