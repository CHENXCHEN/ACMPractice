package leetcode.normal.j1148;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/distance-between-bus-stops/description/">1184. 公交站间的距离</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) {
            int tmp = destination;
            destination = start;
            start = tmp;
        }
        int sum = Arrays.stream(distance).sum(), res = 0;
        for (int i = start; i < destination; i++) res += distance[i];
        return Math.min(res, sum - res);
    }
}