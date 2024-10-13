package leetcode.normal.j1167;

import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-cost-to-connect-sticks/description/">1167. 连接木棍的最低费用</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int connectSticks(int[] sticks) {
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int stick : sticks) {
            pq.add(stick);
        }
        while (pq.size() > 1) {
            Integer x = pq.poll(), y = pq.poll();
            ans += x + y;
            pq.add(x + y);
        }
        return ans;
    }
}