package leetcode.normal.j1144;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/decrease-elements-to-make-array-zigzag/description/">1144. 递减元素使数组呈锯齿状</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int movesToMakeZigzag(int[] nums) {
        // 如果某个位置 i，它是大于附近的数的，那么对它进行操作会使得最终答案变大，
        // 比如 A < B > C，如果对 B 进行操作，使得 B = B - 1，那么 A 和 C 也要相应的进行操作
        // 因此我们不用考虑对某个位置大于周边的这个数进行操作，只需要考虑对某个位置小于周边的操作
        return Math.min(calc(nums, 0), calc(nums, 1));
    }

    int calc(int[] nums, int pos) {
        // 假设从 pos 开始，使得它要小于附近数的最小操作数
        int ans = 0;
        for (int i = pos; i < nums.length; i += 2) {
            int a = 0;
            if (i - 1 >= 0) a = Math.max(a, nums[i] - nums[i - 1] + 1);
            if (i + 1 < nums.length) a = Math.max(a, nums[i] - nums[i + 1] + 1);
            ans += a;
        }
        return ans;
    }
}