package leetcode.normal.j3038;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-number-of-operations-with-the-same-score-i/description/">3038. 相同分数的最大操作数目 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxOperations(int[] nums) {
        int ans = 1, last = nums[0] + nums[1];
        for (int i = 2; i + 1 < nums.length; i+=2) {
            if (nums[i] + nums[i+1] == last) ++ans;
            else break;
        }
        return ans;
    }
}