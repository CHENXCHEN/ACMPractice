package leetcode.normal.j999;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/available-captures-for-rook/description/">999. 可以被一步捕获的棋子数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[][] rookDirections = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int numRookCaptures(char[][] board) {
        int x = 0, y = 0;
        boolean notFound = true;
        int rows = board.length, cols = board[0].length;
        for (int i = 0; i < board.length && notFound; i++) {
            for (int j = 0; j < board[0].length && notFound; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                    notFound = false;
                }
            }
        }
        int ans = 0;
        for (int[] dir : rookDirections) {
            int curX = x, curY = y;
            for (int i = 0; i < 8; i++) {
                curX += dir[0];
                curY += dir[1];
                if (curX < 0 || curX >= rows || curY < 0 || curY >= cols) continue;
                if (board[curX][curY] != '.') {
                    if (board[curX][curY] == 'p') ++ans;
                    break;
                }
            }
        }
        return ans;
    }
}