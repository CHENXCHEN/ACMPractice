package leetcode.normal.j436;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/find-right-interval/
 * 436. 寻找右区间
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {

    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> minStart = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            minStart.put(intervals[i][0], Math.min(minStart.getOrDefault(intervals[i][0], i), i));
        }
        int[] ans = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, Integer> right = minStart.ceilingEntry(intervals[i][1]);
            if (right != null) ans[i] = right.getValue();
            else ans[i] = -1;
        }
        return ans;
    }
}