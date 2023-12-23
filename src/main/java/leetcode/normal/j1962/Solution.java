package leetcode.normal.j1962;

import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/remove-stones-to-minimize-the-total/description/">1962. 移除石子使总数最小</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int pile : piles) {
            pq.add(pile);
        }
        for (int i = 0; i < k; i++) {
            Integer poll = pq.poll();
            pq.add(poll - poll / 2);
        }
        int ans = 0;
        while (!pq.isEmpty()) ans += pq.poll();
        return ans;
    }
}