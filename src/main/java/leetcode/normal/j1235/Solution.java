package leetcode.normal.j1235;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-profit-in-job-scheduling/">1235. 规划兼职工作</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Integer[] pos = new Integer[n];
        for (int i = 0; i < n; i++) pos[i] = i;
        Arrays.sort(pos, (i, j) -> {
            if (startTime[i] != startTime[j]) return startTime[i] - startTime[j];
            return endTime[i] - endTime[j];
        });
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            int start = startTime[pos[i]];
            int end = endTime[pos[i]];
            int vv = profit[pos[i]];
            Map.Entry<Integer, Integer> ceilEntry = tMap.ceilingEntry(end);
            Integer startVal = tMap.getOrDefault(start, 0);
            Map.Entry<Integer, Integer> higherStartEntry = tMap.higherEntry(startVal);
            if (higherStartEntry != null) startVal = Math.max(startVal, higherStartEntry.getValue());
            if (ceilEntry != null) {
                ans = Math.max(ceilEntry.getValue() + vv, ans);
                tMap.put(start, Math.max(startVal, ceilEntry.getValue() + vv));
            } else {
                ans = Math.max(ans, vv);
                tMap.put(start, Math.max(startVal, vv));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] startTime = {1, 2, 3, 4, 6};
        int[] endTime = {3, 5, 10, 6, 9};
        int[] profit = {20, 20, 100, 70, 60};
        solution.jobScheduling(startTime, endTime, profit);
    }
}