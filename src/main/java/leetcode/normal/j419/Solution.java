package leetcode.normal.j419;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/battleships-in-a-board/description/">419. 甲板上的战舰</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countBattleships(char[][] board) {
        int rows = board.length, cols = board[0].length;
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'X') {
                    deque.push(new int[]{i, j});
                    while (!deque.isEmpty()) {
                        int[] pop = deque.pop();
                        int x = pop[0], y = pop[1];
                        board[x][y] = '.';
                        for (int k = 0; k < 4; k++) {
                            int dx = x + dir[k][0], dy = y + dir[k][1];
                            if (dx >= 0 && dx < rows && dy >= 0 && dy < cols && board[dx][dy] == 'X') {
                                deque.push(new int[]{dx, dy});
                            }
                        }
                    }
                    ++ans;
                }
            }
        }
        return ans;
    }
}