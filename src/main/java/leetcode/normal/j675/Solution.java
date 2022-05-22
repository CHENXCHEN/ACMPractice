package leetcode.normal.j675;

import java.util.*;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/cut-off-trees-for-golf-event/
 * 675. 为高尔夫比赛砍树
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int rows, cols;
    int[] visit;

    public int cutOffTree(List<List<Integer>> forest) {
        rows = forest.size();
        cols = forest.get(0).size();
        visit = new int[rows * cols];
        ArrayList<Integer> vv = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Integer value = forest.get(i).get(j);
                if (value > 1) {
                    vv.add(value);
                }
            }
        }
        vv.sort(Comparator.comparingInt(x -> x));
        int ans = 0;
        int startPos = 0;
        for (Integer num : vv) {
            int nextPos = minStep(startPos, num, forest);
            if (nextPos == -1) return -1;
            ans += visit[nextPos];
            startPos = nextPos;
        }
        return ans;
    }

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    int minStep(int startPos, int targetVal, List<List<Integer>> forest) {
        Arrays.fill(visit, -1);
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        visit[startPos] = 0;
        deque.addLast(startPos);
        while (!deque.isEmpty()) {
            int nowPos = deque.removeFirst();
            int nowX = getRow(nowPos);
            int nowY = getCol(nowPos);
            if (forest.get(nowX).get(nowY) == targetVal) {
                return nowPos;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i], nextY = nowY + dy[i];
                if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && forest.get(nextX).get(nextY) > 0) {
                    int nextPos = getPos(nextX, nextY);
                    if (visit[nextPos] == -1) {
                        visit[nextPos] = visit[nowPos] + 1;
                        deque.addLast(nextPos);
                    }
                }
            }
        }
        return -1;
    }

    int getRow(int now) {
        return now / cols;
    }

    int getCol(int now) {
        return now % cols;
    }

    int getPos(int x, int y) {
        return x * cols + y;
    }
}