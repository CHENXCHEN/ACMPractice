package leetcode.normal.j2293;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/min-max-game/description/">2293. 极大极小游戏</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] nums;
    int level;

    public int minMaxGame(int[] nums) {
        this.nums = nums;
        int len = nums.length;
        level = 0;
        while (len > 0) {
            level++;
            len >>= 1;
        }
        return findMinMax(1, 0);
    }

    int findMinMax(int pos, int step) {
        if (step == level - 1) {
            return nums[pos - 1];
        }
        return (pos & 1) == 1 ?
                Math.min(findMinMax(pos << 1, step + 1), findMinMax((pos << 1) - 1, step + 1)) :
                Math.max(findMinMax(pos << 1, step + 1), findMinMax((pos << 1) - 1, step + 1));
    }
}