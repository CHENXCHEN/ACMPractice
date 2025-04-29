package leetcode.normal.j3392;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-subarrays-of-length-three-with-a-condition/description/">3392. 统计符合条件长度为 3 的子数组数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countSubarrays(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if ((nums[i - 1] + nums[i + 1]) * 2 == nums[i]) ++ans;
        }
        return ans;
    }
}