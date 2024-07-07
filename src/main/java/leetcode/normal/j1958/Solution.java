package leetcode.normal.j1958;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/check-if-move-is-legal/description/">1958. 检查操作是否合法</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int rows, cols;
    char[][] board;

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        rows = board.length;
        cols = board[0].length;
        this.board = board;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue;
                if (checkDirect(new int[]{dx, dy}, rMove, cMove, color, color == 'W' ? 'B' : 'W'))
                    return true;
            }
        }
        return false;
    }

    boolean checkDirect(int[] direct, int x, int y, char color, char otherColor) {
        int nx = x + direct[0], ny = y + direct[1];
        int otherCnt = 0;
        while (checkBoard(nx, ny) && board[nx][ny] == otherColor) {
            otherCnt++;
            nx += direct[0];
            ny += direct[1];
        }
        return checkBoard(nx, ny) && board[nx][ny] == color && otherCnt > 0;
    }

    boolean checkBoard(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}