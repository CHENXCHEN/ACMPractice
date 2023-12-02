package leetcode.normal.j1094;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/car-pooling/description/">1094. 拼车</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] vis = new int[1001];
        for (int[] trip : trips) {
            vis[trip[1]] -= trip[0];
            vis[trip[2]] += trip[0];
        }
        for (int i = 0; i <= 1000; i++) {
            capacity += vis[i];
            if (capacity < 0) return false;
        }
        return true;
    }
}