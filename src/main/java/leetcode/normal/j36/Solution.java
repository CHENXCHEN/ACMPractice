package leetcode.normal.j36;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/valid-sudoku/
 * 36. 有效的数独
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        return validRowOrCol(board, true) & validRowOrCol(board, false) & validGrip(board);
    }

    boolean validRowOrCol(char[][] board, boolean isRow) {
        for (int i = 0; i < 9; i++) {
            int rValid = 0;
            for (int j = 0; j < 9; j++) {
                char ch;
                if (isRow) ch = board[i][j];
                else ch = board[j][i];
                if (ch != '.') {
                    int num = ch - '0';
                    if (((rValid >> num) & 1) == 1) {
                        return false;
                    }
                    rValid |= 1 << num;
                }
            }
        }
        return true;
    }

    boolean validGrip(char[][] board) {
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                int rValid = 0;
                for (int dx = 0; dx < 3; dx++) {
                    for (int dy = 0; dy < 3; dy++) {
                        char ch = board[i + dx][j + dy];
                        if (ch != '.') {
                            int num = ch - '0';
                            if (((rValid >> num) & 1) == 1) {
                                return false;
                            }
                            rValid |= 1 << num;
                        }
                    }
                }
            }
        }
        return true;
    }
}