package leetcode.normal.j2056;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-valid-move-combinations-on-chessboard/description/">2056. 棋盘上有效移动组合的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    static class Movement {
        int startX, startY, endX, endY, dx, dy, curX, curY;

        public Movement(int startX, int startY, int endX, int endY, int dx, int dy) {
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
            this.dx = dx;
            this.dy = dy;
        }

        void reset() {
            this.curX = startX;
            this.curY = startY;
        }

        boolean stopped() {
            return curX == endX && curY == endY;
        }

        void move() {
            if (!stopped()) {
                curX += dx;
                curY += dy;
            }
        }

        boolean cross(Movement other) {
            reset();
            other.reset();
            while (!stopped() || !other.stopped()) {
                move();
                other.move();
                if (curX == other.curX && curY == other.curY) {
                    return true;
                }
            }
            return false;
        }
    }

    int n, ans;
    List<Movement> stack;
    String[] pieces;
    int[][] positions;
    int[][] rookDirections = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][] bishopDirections = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
    int[][] queueDirections = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};

    public int countCombinations(String[] pieces, int[][] positions) {
        n = positions.length;
        stack = new ArrayList<>();
        this.pieces = pieces;
        this.positions = positions;
        ans = 0;
        dfs(0);
        return ans;
    }

    void dfs(int u) {
        if (u == n) {
            ++ans;
            return;
        }
        // 原地不动
        stack.add(new Movement(positions[u][0], positions[u][1], positions[u][0], positions[u][1], 0, 0));
        if (check(u)) {
            dfs(u + 1);
        }
        stack.remove(stack.size() - 1);
        int[][] directions;
        if ("rook".equals(pieces[u])) {
            directions = rookDirections;
        } else if ("queen".equals(pieces[u])) {
            directions = queueDirections;
        } else {
            directions = bishopDirections;
        }

        // 枚举第 u 个棋子在所有方向，所有步数的情况
        for (int[] direction : directions) {
            for (int j = 1; j < 8; j++) {
                int x = positions[u][0] + j * direction[0];
                int y = positions[u][1] + j * direction[1];
                if (x < 1 || x > 8 || y < 1 || y > 8) break;
                stack.add(new Movement(positions[u][0], positions[u][1], x, y, direction[0], direction[1]));
                if (check(u)) {
                    dfs(u + 1);
                }
                stack.remove(stack.size() - 1);
            }
        }
    }

    boolean check(int u) {
        for (int v = 0; v < u; v++) {
            if (stack.get(u).cross(stack.get(v))) {
                return false;
            }
        }
        return true;
    }

}