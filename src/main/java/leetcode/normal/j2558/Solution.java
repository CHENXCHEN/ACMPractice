package leetcode.normal.j2558;

import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/take-gifts-from-the-richest-pile/description/">2558. 从数量最多的堆取走礼物</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        for (int gift : gifts) {
            pq.add(gift);
        }
        for (int i = 0; i < k; i++) {
            Integer cur = pq.poll();
            int sqrt = (int)Math.sqrt(cur);
            pq.add(sqrt);
        }
        long ans = 0;
        while (!pq.isEmpty()) ans += pq.poll();
        return ans;
    }
}