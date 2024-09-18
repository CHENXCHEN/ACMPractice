package leetcode.normal.j2332;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/the-latest-time-to-catch-a-bus/description/">2332. 坐上公交的最晚时间</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        // pos => 到 pos 为止的乘客都已经离开
        // space => 当前有多少座位空余
        int pos = 0, space = 0;
        for (int arrive : buses) {
            space = capacity;
            // 乘客挨个上车
            while (space > 0 && pos < passengers.length && passengers[pos] <= arrive) {
                space--;
                pos++;
            }
        }
        pos--;
        // 从最后一班车往前开始找空闲时间
        int lastCatchTime = space > 0 ? buses[buses.length - 1] : passengers[pos];
        while (pos >= 0 && passengers[pos] == lastCatchTime) {
            pos--;
            lastCatchTime--;
        }
        return lastCatchTime;
    }
}