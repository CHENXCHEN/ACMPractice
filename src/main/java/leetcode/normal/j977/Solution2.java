package leetcode.normal.j977;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/squares-of-a-sorted-array/description/">977. 有序数组的平方</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int i = 0;
        while (i < nums.length && nums[i] < 0) i++;
        int j = i - 1, pos = 0;
        while (j >= 0 && i < nums.length) {
            if (nums[i] > -nums[j]) {
                ans[pos++] = nums[j] * nums[j];
                --j;
            } else {
                ans[pos++] = nums[i] * nums[i];
                ++i;
            }
        }
        while (j >= 0) {
            ans[pos++] = nums[j] * nums[j];
            --j;
        }
        while (i < nums.length) {
            ans[pos++] = nums[i] * nums[i];
            ++i;
        }
        return ans;
    }
}