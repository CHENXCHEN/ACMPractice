package leetcode.normal.j3066;

import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-operations-to-exceed-threshold-value-ii/description/">3066. 超过阈值的最少操作数 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add((long) num);
        }
        int ans = 0;
        while (!pq.isEmpty() && pq.size() >= 2) {
            Long cur = pq.poll();
            if (cur >= k) break;
            Long next = pq.poll();
            pq.add(Math.min(cur, next) * 2 + Math.max(cur, next));
            ++ans;
        }
        return ans;
    }
}