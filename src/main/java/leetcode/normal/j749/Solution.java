package leetcode.normal.j749;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/contain-virus/">749. 隔离病毒</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    public int containVirus(int[][] isInfected) {
        int rows = isInfected.length, cols = isInfected[0].length, ans = 0;
        while (true) {
            ArrayList<Set<Integer>> neighbors = new ArrayList<>();
            ArrayList<Integer> firewalls = new ArrayList<>();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (isInfected[i][j] == 1) {
                        ArrayDeque<int[]> deque = new ArrayDeque<>();
                        deque.add(new int[]{i, j});
                        int firewallCnt = 0, number = neighbors.size() + 1;
                        isInfected[i][j] = -number;
                        Set<Integer> neighbor = new TreeSet<>();
                        while (!deque.isEmpty()) {
                            int[] now = deque.pop();
                            for (int k = 0; k < 4; k++) {
                                int[] next = new int[]{now[0] + dx[k], now[1] + dy[k]};
                                if (next[0] >= 0 && next[0] < rows && next[1] >= 0 && next[1] < cols) {
                                    if (isInfected[next[0]][next[1]] == 1) {
                                        deque.add(next);
                                        isInfected[next[0]][next[1]] = -number;
                                    } else if (isInfected[next[0]][next[1]] == 0) {
                                        firewallCnt++;
                                        neighbor.add((next[0] << 16) | next[1]);
                                    }
                                }
                            }
                        }
                        neighbors.add(neighbor);
                        firewalls.add(firewallCnt);
                    }
                }
            }
            if (neighbors.isEmpty()) break;
            // 找到有最大邻居的编号
            int idx = 0;
            for (int i = 1; i < neighbors.size(); i++) {
                if (neighbors.get(i).size() > neighbors.get(idx).size()) {
                    idx = i;
                }
            }
            ans += firewalls.get(idx);
            // 将最大邻居围上围墙，非最大邻居变为1
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (isInfected[i][j] < 0) {
                        if (isInfected[i][j] == -idx - 1) {
                            isInfected[i][j] = 2;
                        } else {
                            isInfected[i][j] = 1;
                        }
                    }
                }
            }
            // 将除了最大邻居的其他编号邻居变为感染
            for (int i = 0; i < neighbors.size(); i++) {
                if (i != idx) {
                    for (int pos : neighbors.get(i)) {
                        int x = pos >> 16;
                        int y = pos & 0xffff;
                        isInfected[x][y] = 1;
                    }
                }
            }
            if (neighbors.size() == 1) break;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] mp = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 1, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        solution.containVirus(mp);
    }
}