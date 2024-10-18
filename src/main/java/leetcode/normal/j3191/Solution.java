package leetcode.normal.j3191;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/description/">3191. 使二进制数组全部等于 1 的最少操作次数 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i + 2 < n; i++) {
            if (nums[i] == 0) {
                nums[i] = 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                ++ans;
            }
        }
        if (nums[n - 1] == 0 || nums[n - 2] == 0) return -1;
        return ans;
    }
}