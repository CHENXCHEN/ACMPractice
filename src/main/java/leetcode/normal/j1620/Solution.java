package leetcode.normal.j1620;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/coordinate-with-maximum-network-quality/description/">1620. 网络信号最好的坐标</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int xMax = 0, yMax = 0;
        for (int[] tower : towers) {
            xMax = Math.max(xMax, tower[0]);
            yMax = Math.max(yMax, tower[1]);
        }
        int ansX = 0, ansY = 0, ans = -1;
        for (int i = 0; i <= xMax; i++) {
            for (int j = 0; j <= yMax; j++) {
                int vv = calcVal(towers, radius, i, j);
                if (vv > ans) {
                    ansX = i;
                    ansY = j;
                    ans = vv;
                }
            }
        }
        return new int[]{ansX, ansY};
    }

    int calcVal(int[][] towers, int radius, int x, int y) {
        int ans = 0, r2 = radius * radius;
        for (int[] tower : towers) {
            int dis = distance(tower[0], tower[1], x, y);
            if (dis <= r2) {
                ans += tower[2] / (1 + Math.sqrt(dis));
            }
        }
        return ans;
    }

    int distance(int x, int y, int x1, int y1) {
        int dx = x - x1, dy = y - y1;
        return dx * dx + dy * dy;
    }
}