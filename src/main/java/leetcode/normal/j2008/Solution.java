package leetcode.normal.j2008;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-earnings-from-taxi/description/">2008. 出租车的最大盈利</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        int m = rides.length;
        long last = 0L;
        Integer[] pos = new Integer[m];
        for (int i = 0; i < m; i++) pos[i] = i;
        Arrays.sort(pos, (x, y) -> Integer.compare(rides[x][0], rides[y][0]));
        TreeMap<Integer, Long> tMap = new TreeMap<>();
        for (int i = m - 1; i >= 0; i--) {
            int idx = pos[i];
            Map.Entry<Integer, Long> entry = tMap.ceilingEntry(rides[idx][1]);
            long cur = rides[idx][1] - rides[idx][0] + rides[idx][2];
            if (entry != null) cur += entry.getValue();
            long mx = Math.max(Math.max(tMap.getOrDefault(rides[idx][0], 0L), cur), last);
            last = Math.max(last, mx);
            tMap.put(rides[idx][0], mx);
        }
        return last;
    }
}