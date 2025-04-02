package leetcode.normal.j2873;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-value-of-an-ordered-triplet-i/description/">2873. 有序三元组中的最大值 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    ans = Math.max(ans, (long) (nums[i] - nums[j]) * nums[k]);
                }
            }
        }
        return ans;
    }
}