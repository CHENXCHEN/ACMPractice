package leetcode.normal.j3001;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-moves-to-capture-the-queen/description/">3001. 捕获黑皇后需要的最少移动次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {

    int[][] rookDirections = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][] bishopDirections = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};

    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        int[] rook = {a, b}, bishop = {c, d}, queen = {e, f};
        // 如果车可以直接接触到皇后，那么为1
        if (check(rook, bishop, queen, rookDirections)) return 1;
        // 如果象可以直接接触到皇后，那么为1
        if (check(bishop, rook, queen, bishopDirections)) return 1;
        return 2;
    }

    boolean check(int[] start, int[] other, int[] target, int[][] directions) {
        for (int[] d : directions) {
            int x = start[0], y = start[1];
            for (int i = 1; i < 8; i++) {
                x += d[0];
                y += d[1];
                if (x < 1 || x > 8 || y < 1 || y > 8) break;
                if (x == other[0] && y == other[1]) break;
                if (x == target[0] && y == target[1]) return true;
            }
        }
        return false;
    }
}