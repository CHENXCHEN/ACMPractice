package leetcode.normal.j871;

import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-number-of-refueling-stops/solution/zui-di-jia-you-ci-shu-by-leetcode-soluti-nmga/">871. 最低加油次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution3 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        int cur = startFuel, pre = 0, ans = 0, n = stations.length;
        for (int i = 0; i <= n; i++) {
            int now = i < n ? stations[i][0] : target;
            cur -= now - pre;
            while (cur < 0 && !pq.isEmpty()) {
                cur += pq.poll();
                ans++;
            }
            if (cur < 0) return -1;
            if (i < n) {
                pre = now;
                pq.add(stations[i][1]);
            }
        }
        return ans;
    }
}