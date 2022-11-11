package leetcode.normal.j864;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/shortest-path-to-get-all-keys/">864. 获取所有钥匙的最短路径</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] startPos;
    ArrayDeque<int[]> deque = new ArrayDeque<>();
    Map<Character, Integer> keyToIdx = new HashMap<>();
    String[] grid;
    int ans, rows, cols;
    int[][][] dis;
    int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

    public int shortestPathAllKeys(String[] grid) {
        this.grid = grid;
        ans = -1;
        rows = grid.length;
        cols = grid[0].length();
        deque.clear();
        int[] startPos = new int[3];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char ch = grid[i].charAt(j);
                if (ch == '@') {
                    startPos[0] = i;
                    startPos[1] = j;
                } else if (Character.isLowerCase(ch)) {
                    keyToIdx.put(ch, keyToIdx.size());
                }
            }
        }
        dis = new int[rows][cols][1 << keyToIdx.size()];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Arrays.fill(dis[i][j], -1);
            }
        }
        dis[startPos[0]][startPos[1]][0] = 0;
        deque.add(startPos);
        while (!deque.isEmpty()) {
            int[] nowPos = deque.pop();
            int mask = nowPos[2];
            int nowStep = dis[nowPos[0]][nowPos[1]][mask];
            if (Integer.bitCount(mask) == keyToIdx.size() && (ans == -1 || nowStep < ans)) {
                ans = nowStep;
            }
            for (int i = 0; i < 4; i++) {
                int[] nextPos = new int[]{nowPos[0] + dx[i], nowPos[1] + dy[i], mask};
                if (nextPos[0] >= 0 && nextPos[0] < rows && nextPos[1] >= 0 && nextPos[1] < cols) {
                    char ch = grid[nextPos[0]].charAt(nextPos[1]);
                    int nextStep = dis[nextPos[0]][nextPos[1]][mask];
                    if (ch != '#') {
                        boolean haveKey = !Character.isUpperCase(ch) || (((mask >> keyToIdx.get(Character.toLowerCase(ch))) & 1) == 1);
                        int nextMask = Character.isLowerCase(ch) ? mask | (1 << keyToIdx.get(ch)) : mask;
                        nextPos[2] = nextMask;
                        if (haveKey && (nextStep == -1 || nowStep + 1 < nextStep)) {
                            dis[nextPos[0]][nextPos[1]][nextMask] = nowStep + 1;
                            deque.add(nextPos);
                        }
                    }
                }
            }
        }
        return ans;
    }
}