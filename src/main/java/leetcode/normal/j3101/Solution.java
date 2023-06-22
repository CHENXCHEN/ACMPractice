package leetcode.normal.j3101;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/pond-sizes-lcci/">面试题 16.19. 水域大小</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    class Node {
        int x, y;

        Node(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }

    int[][] land;
    int rows, cols;

    public int[] pondSizes(int[][] land) {
        this.land = land;
        rows = land.length;
        cols = land[0].length;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (land[i][j] == 0) {
                    ans.add(bfs(i, j));
                }
            }
        }
        ans.sort(Comparator.comparingInt(x -> x));
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) res[i] = ans.get(i);
        return res;
    }

    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};

    boolean inBoard(Node node) {
        return node.x >= 0 && node.x < rows && node.y >= 0 && node.y < cols;
    }

    int bfs(int x, int y) {
        int cnt = 1;
        land[x][y] = 1;
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(x, y));
        while (!deque.isEmpty()) {
            Node now = deque.poll();
            for (int[] d : dir) {
                Node next = new Node(now.x + d[0], now.y + d[1]);
                if (inBoard(next) && land[next.x][next.y] == 0) {
                    ++cnt;
                    land[next.x][next.y] = 1;
                    deque.add(next);
                }
            }
        }
        return cnt;
    }
}