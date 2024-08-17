package leetcode.normal.j2411;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/smallest-subarrays-with-maximum-bitwise-or/description/">2411. 按位或最大的最小子数组长度</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = 1;
            // 处理完了之后，nums[j] 相当于 [j,i-1] 按位或的值
            // 若 nums[j] & nums[i] = nums[j]，那么 nums[i] 相当于 nums[j] 的子集，之后再往前也不会增大，所以可以终止
            for (int j = i - 1; j >= 0 && (nums[j] | nums[i]) != nums[j]; j--) {
                nums[j] |= nums[i];
                ans[j] = i - j + 1;
            }
        }
        return ans;
    }
}