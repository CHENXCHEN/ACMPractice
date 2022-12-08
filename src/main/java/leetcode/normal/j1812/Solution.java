package leetcode.normal.j1812;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/determine-color-of-a-chessboard-square/"><1812. 判断国际象棋棋盘中一个格子的颜色/a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean squareIsWhite(String coordinates) {
        int num = coordinates.charAt(0) - 'a' + 1 + coordinates.charAt(1) - '0';
        return (num & 1) == 1;
    }
}