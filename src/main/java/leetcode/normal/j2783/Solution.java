package leetcode.normal.j2783;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/fHi6rV/">LCP 41. 黑白翻转棋</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int rows, cols;
    String[] chessboard;

    public int flipChess(String[] chessboard) {
        this.chessboard = chessboard;
        rows = chessboard.length;
        cols = chessboard[0].length();
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (chessboard[i].charAt(j) == '.') {
                    int bfs = bfs(i, j);
                    ans = Math.max(ans, bfs);
                }
            }
        }
        return ans;
    }

    int countBlack(CharSequence[] chess) {
        int cnt = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (chess[i].charAt(j) == 'X') ++cnt;
            }
        }
        return cnt;
    }

    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

    int bfs(int startX, int startY) {
        StringBuffer[] chess = new StringBuffer[rows];
        for (int i = 0; i < rows; i++) chess[i] = new StringBuffer(chessboard[i]);
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(startX * cols + startY);
        chess[startX].setCharAt(startY, 'X');
        int cnt = 0;
        while (!deque.isEmpty()) {
            int cur = deque.poll();
            int x = cur / cols, y = cur % cols;
            for (int[] d : dir) {
                int tmpX = x + d[0], tmpY = y + d[1];
                ArrayList<Integer> path = new ArrayList<>();
                while (inBoard(tmpX, tmpY) && (chess[tmpX].charAt(tmpY) == 'O')) {
                    path.add(tmpX * cols + tmpY);
                    tmpX += d[0];
                    tmpY += d[1];
                }
                if (inBoard(tmpX, tmpY) && (chess[tmpX].charAt(tmpY) == 'X')) {
                    for (Integer node : path) {
                        int cx = node / cols, cy = node % cols;
                        if (chess[cx].charAt(cy) != 'X') {
                            ++cnt;
                            chess[cx].setCharAt(cy, 'X');
                            deque.add(cx * cols + cy);
                        }
                    }
                }
            }
        }
        return cnt;
    }

    boolean inBoard(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] chess = {"....X.", "....X.", "XOOO..", "......", "......"};
        solution.flipChess(chess);
    }
}