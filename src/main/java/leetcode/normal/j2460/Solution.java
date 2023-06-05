package leetcode.normal.j2460;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/apply-operations-to-an-array/">2460. 对数组执行操作</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != 0 && nums[i] == nums[i + 1]) {
                nums[i] <<= 1;
                nums[i + 1] = 0;
            }
        }
        int[] ans = new int[nums.length];
        int tot = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) ans[tot++] = nums[i];
        }
        return ans;
    }
}