package leetcode.normal.j292;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/nim-game/description/">292. Nim 游戏</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean canWinNim(int n) {
        return (n & 0x3) != 0;
    }
}