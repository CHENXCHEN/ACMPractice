package leetcode.normal.j1184;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/distance-between-bus-stops/">1184. 公交站间的距离</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start == destination) return 0;
        int[] ans = new int[2];
        int n = distance.length;
        int idx = 0, from = start;
        do {
            ans[idx] += distance[from];
            ++from;
            if (from == n) from = 0;
            if (from == destination) ++idx;
        } while (from != start);
        return Math.min(ans[0], ans[1]);
    }
}