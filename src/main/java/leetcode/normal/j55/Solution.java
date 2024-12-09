package leetcode.normal.j55;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/jump-game/">55. 跳跃游戏</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int n = nums.length, end = 0, maxPosition = 0;
        for (int i = 0; i < n - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (maxPosition >= n - 1) return true;
            if (i == end) {
                if (maxPosition == i) break;
                end = maxPosition;
            }
        }
        return false;
    }
}