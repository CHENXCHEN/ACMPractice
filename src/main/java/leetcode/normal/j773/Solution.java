package leetcode.normal.j773;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/sliding-puzzle/
 * 773. 滑动谜题
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int slidingPuzzle(int[][] board) {
        int[] visit = new int[543212];
        StringBuilder sb = new StringBuilder();
        for (int[] cols : board) {
            for (int col : cols) {
                sb.append(col);
            }
        }
        int start = Integer.parseInt(sb.toString());
        Arrays.fill(visit, -1);
        visit[start] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == 123450) return visit[now];
            int zeroPos = getPosFromVal(now, 0);
            int x = zeroPos / 3, y = zeroPos % 3;
            int step = visit[now];
            for (int[] dir : dirs) {
                int tx = x + dir[0];
                int ty = y + dir[1];
                if (0 <= tx && tx < 2 && 0 <= ty && ty < 3) {
                    int next = tx * 3 + ty;
                    int nextNum = swatPosVal(now, zeroPos, next);
                    if (visit[nextNum] == -1 || visit[nextNum] > step + 1) {
                        q.add(nextNum);
                        visit[nextNum] = step + 1;
                    }
                }
            }
        }
        return -1;
    }

    public int getPosFromVal(int num, int vv) {
        for (int i = 0; i < 6; i++) {
            if (getValFromPos(num, i) == vv) return i;
        }
        return -1;
    }

    public int getValFromPos(int num, int pos) {
        int base = (int) Math.pow(10, 5 - pos);
        return num / base % 10;
    }

    public int swatPosVal(int num, int pos1, int pos2) {
        int base1 = (int) Math.pow(10, 5 - pos1);
        int base2 = (int) Math.pow(10, 5 - pos2);
        int v1 = num / base1 % 10;
        int v2 = num / base2 % 10;
        return num - v1 * base1 - v2 * base2 + v1 * base2 + v2 * base1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
                solution.slidingPuzzle(new int[][]{{1,2,3},{4,0,5}})
        );
    }
}