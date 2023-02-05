package leetcode.normal.j1210;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-moves-to-reach-target-with-rotations/">1210. 穿过迷宫的最少移动次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int rows, cols;
    int vertical = 0, horizontal = 1;
    int[][] grid;

    public int minimumMoves(int[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        // 分别为：右，下，旋转到垂直，旋转到水平
        int[][] dir = {{0, 1}, {1, 0}, {1, -1}, {-1, 1}};
        int[][][] needCheck = {{{-1, 1}, {}, {}, {0, 1}}, {{}, {1, -1}, {1, 0}, {}}};
        ArrayDeque<Pair<Pair<Integer, Integer>, Integer>> deque = new ArrayDeque<>();
        deque.add(new Pair<>(new Pair<>(0, 1), horizontal));
        int[][][] dis = new int[2][rows][cols];
        for (int i = 0; i < dis.length; i++)
            for (int j = 0; j < dis[i].length; j++)
                Arrays.fill(dis[i][j], -1);
        dis[horizontal][0][1] = 0;
        while (!deque.isEmpty()) {
            Pair<Pair<Integer, Integer>, Integer> now = deque.poll();
            Pair<Integer, Integer> nowPos = now.getKey();
            Integer nowDir = now.getValue();
            for (int i = 0; i < 4; i++) {
                Pair<Integer, Integer> nextPos = getNextPos(nowPos, dir[i]);
                int nextDir = nowDir;
                if (!isPosValid(nextPos)) continue;
                // 如果是垂直，那么不能再旋转到垂直
                if (nowDir == vertical && i == 2) continue;
                // 如果是水平，那么不能再旋转到水平
                if (nowDir == horizontal && i == 3) continue;
                // 如果下一步操作是不合法的，跳过
                if (!isPosValidForNeed(nowPos, needCheck[nowDir][i])) continue;
                if (i > 1) nextDir ^= 1;
                if (dis[nextDir][nextPos.getKey()][nextPos.getValue()] == -1 ||
                        dis[nextDir][nextPos.getKey()][nextPos.getValue()] > dis[nowDir][nowPos.getKey()][nowPos.getValue()] + 1) {
//                    System.out.println("" + nowPos + " dir " + nowDir + " -> " + nextPos + " dir " + nextDir);
                    dis[nextDir][nextPos.getKey()][nextPos.getValue()] = dis[nowDir][nowPos.getKey()][nowPos.getValue()] + 1;
                    deque.add(new Pair<>(nextPos, nextDir));
                }
            }
        }
        return dis[horizontal][rows - 1][cols - 1];
    }

    Pair<Integer, Integer> getNextPos(Pair<Integer, Integer> now, int[] dir) {
        return new Pair<>(now.getKey() + dir[0], now.getValue() + dir[1]);
    }

    boolean isPosValid(Pair<Integer, Integer> pos) {
        return pos.getKey() >= 0 && pos.getKey() < rows && pos.getValue() >= 0 && pos.getValue() < cols && grid[pos.getKey()][pos.getValue()] == 0;
    }

    boolean isPosValidForNeed(Pair<Integer, Integer> now, int[] dir) {
        if (dir.length == 0) return true;
        return isPosValid(getNextPos(now, dir));
    }
}