package leetcode.normal.j3232;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-if-digit-game-can-be-won/description/">3232. 判断是否可以赢得数字游戏</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean canAliceWin(int[] nums) {
        int s1 = 0, s2 = 0;
        for (int num : nums) {
            if (num < 10) s1 += num;
            else s2 += num;
        }
        return s1 != s2;
    }
}