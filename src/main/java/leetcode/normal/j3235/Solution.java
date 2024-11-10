package leetcode.normal.j3235;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/check-if-the-rectangle-corner-is-reachable/description/">3235. 判断矩形的两个角落是否可达</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] parent;
    int[] mark;
    int xCorner, yCorner;

    public boolean canReachCorner(int xCorner, int yCorner, int[][] circles) {
        this.xCorner = xCorner;
        this.yCorner = yCorner;
        int n = circles.length;
        parent = new int[n];
        mark = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int i = 0; i < n; i++) {
            // 如果左下角或右上角在圆内，则一定不可
            int x1 = circles[i][0];
            int y1 = circles[i][1];
            int r1 = circles[i][2];
            if (pointInCircle(0, 0, x1, y1, r1) || pointInCircle(xCorner, yCorner, x1, y1, r1))
                return false;
            if (circleIntersectTopLeft(xCorner, yCorner, x1, y1, r1)) mark[i] |= 1;
            if (circleIntersectBottomRight(xCorner, yCorner, x1, y1, r1)) mark[i] |= 2;
            for (int j = i + 1; j < n; j++) {
                int x2 = circles[j][0];
                int y2 = circles[j][1];
                int r2 = circles[j][2];
                if (circleIntersectInRectangle(xCorner, yCorner, x1, y1, r1, x2, y2, r2))
                    union(i, j);
            }
        }
        for (int i = 0; i < n; i++) {
            int fa = find(i);
            mark[fa] |= mark[i];
            if (mark[fa] == 3) return false;
        }
        return true;
    }

    boolean pointInCircle(long px, long py, long x, long y, long r) {
        return (px - x) * (px - x) + (py - y) * (py - y) <= r * r;
    }

    boolean circleIntersectTopLeft(long xCorner, long yCorner, long x, long y, long r) {
        // 1. 判断左边，若 0 <= y <= yCorner，且 x + r >= 0 && x - r <=0 => |x| <= r
        // 2. 判断右边，若 0 <= x <= xCorner，且 y + r >= yCorner && y - r <= yCorner => |y - yCorner| <= r
        // 3. 判断顶点，若 (0, yCorner) 位于圆内
        return (0 <= y && y <= yCorner && Math.abs(x) <= r) || (0 <= x && x <= xCorner && Math.abs(y - yCorner) <= r) || pointInCircle(0, yCorner, x, y, r);
    }

    boolean circleIntersectBottomRight(long xCorner, long yCorner, long x, long y, long r) {
        // 1. 判断右边，若 0 <= y <= yCorner, 且 x + r >= xCorner && x - r <= xCorner => |x - xCorner| <= r
        // 2. 判断左边，若 0 <= x <= xCorner，且 y + r >= 0 && y - r <= 0 => |y| <= r
        // 3. 判断顶点，若 (xCorner, 0) 在圆内
        return (0 <= y && y <= yCorner && Math.abs(x - xCorner) <= r) || (0 <= x && x <= xCorner && Math.abs(y) <= r) || pointInCircle(xCorner, 0, x, y, r);
    }

    boolean circleIntersectInRectangle(long xCorner, long yCorner, long x1, long y1, long r1, long x2, long y2, long r2) {
        // 判断圆的相交点是否位于举行内，需要满足以下条件：
        // 1. 圆相交
        // 2. 两圆(O1 & O2)相交的点A坐标在举行内
        //      两圆相交的点A，令 |O1A| = r1，则 |O1A| / |O1O2| = r1 / (r1 + r2)，则 O1(x) 到 A(x) 的长度比也为 r1 / (r1 + r2)
        //      可得：A(x) = x1 + r1 / (r1 + r2) * (x2 - x1) => (x1r2 + x2r1) / (r1 + r2)
        //      同理：A(y) = y1 + r1 / (r1 + r2) * (y2 - y1) => (y1r2 + y2r1) / (r1 + r2)
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) <= (r1 + r2) * (r1 + r2) && x1 * r2 + x2 * r1 < (r1 + r2) * xCorner && y1 * r2 + y2 * r1 < (r1 + r2) * yCorner;
    }

    int find(int x) {
        return x == parent[x] ? x : (parent[x] = find(parent[x]));
    }

    void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx > fy) parent[fx] = fy;
        else parent[fy] = fx;
    }
}