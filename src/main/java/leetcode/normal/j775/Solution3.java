package leetcode.normal.j775;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/global-and-local-inversions/description/">775. 全局倒置与局部倒置</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution3 {
    public boolean isIdealPermutation(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i] - i) > 1) return false;
        }
        return true;
    }
}