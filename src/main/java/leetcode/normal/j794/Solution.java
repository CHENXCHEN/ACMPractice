package leetcode.normal.j794;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/valid-tic-tac-toe-state/
 * 794. 有效的井字游戏
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    boolean isWin(String[] board, char target) {
        boolean isRow = false;
        boolean isCol = false;
        for (int i = 0; i < 3; i++) {
            int cnt1 = 0, cnt2 = 0;
            for (int j = 0; j < 3; j++) {
                char ch1 = board[i].charAt(j);
                char ch2 = board[j].charAt(i);
                if (ch1 == target) cnt1++;
                if (ch2 == target) cnt2++;
            }
            if (cnt1 == 3) isRow = true;
            if (cnt2 == 3) isCol = true;
        }
        return isRow || isCol ||
                (board[0].charAt(0) == target && board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2)) ||
                (board[0].charAt(2) == target && board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0));
    }

    public boolean validTicTacToe(String[] board) {
        int cnt1 = 0;
        int cnt2 = 0;
        boolean isP1Win = isWin(board, 'X');
        boolean isP2Win = isWin(board, 'O');
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char ch = board[i].charAt(j);
                if (ch == 'X') cnt1++;
                else if (ch == 'O') cnt2++;
            }
        }
        if (isP1Win && isP2Win) return false;
        else if (isP1Win) return cnt1 == cnt2 + 1;
        else if (isP2Win) return cnt1 == cnt2;
        else return cnt1 == cnt2 + 1 || cnt1 == cnt2;
    }
}