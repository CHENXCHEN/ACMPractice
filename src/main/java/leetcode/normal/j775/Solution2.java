package leetcode.normal.j775;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/global-and-local-inversions/description/">775. 全局倒置与局部倒置</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length, minNum = nums[n - 1];
        for (int i = n - 3; i >= 0; i--) {
            if (nums[i] > minNum) return false;
            minNum = Math.min(minNum, nums[i + 1]);
        }
        return true;
    }
}