package leetcode.normal.j1851;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-interval-to-include-each-query/">1851. 包含每个查询的最小区间</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Integer[] queryPos = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) queryPos[i] = i;
        Arrays.sort(queryPos, (i, j) -> queries[i] - queries[j]);
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);
        int i = 0;
        for (int qPos : queryPos) {
            while (i < intervals.length && intervals[i][0] <= queries[qPos]) {
                pq.add(new int[]{intervals[i][1] - intervals[i][0] + 1, intervals[i][0], intervals[i][1]});
                i++;
            }
            while (!pq.isEmpty() && pq.peek()[2] < queries[qPos]) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                ans[qPos] = pq.peek()[0];
            }
        }
        return ans;
    }
}