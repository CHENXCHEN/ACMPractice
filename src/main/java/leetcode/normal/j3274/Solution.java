package leetcode.normal.j3274;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/check-if-two-chessboard-squares-have-the-same-color/description/">3274. 检查棋盘方格颜色是否相同</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int parse1 = parse(coordinate1), parse2 = parse(coordinate2);
        return (parse1 & 1) == (parse2 & 1);
    }

    int parse(String coordinate) {
        return coordinate.charAt(0) - 'a' + coordinate.charAt(1) - '1';
    }
}