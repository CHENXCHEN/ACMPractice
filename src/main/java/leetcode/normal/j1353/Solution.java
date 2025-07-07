package leetcode.normal.j1353;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-number-of-events-that-can-be-attended/description/">1353. 最多可以参加的会议数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int maxDay = 0, n = events.length;
        for (int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }

        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1, j = 0; i <= maxDay; i++) {
            // 将开始时间 <= i 的结束时间都入队列
            while (j < n && events[j][0] <= i) {
                pq.offer(events[j][1]);
                j++;
            }
            // 将结束时间 < i 的都出队列
            while (!pq.isEmpty() && pq.peek() < i) {
                pq.poll();
            }
            // 如果非空，则优先取结束时间最早的
            if (!pq.isEmpty()) {
                pq.poll();
                ++ans;
            }
        }
        return ans;
    }
}