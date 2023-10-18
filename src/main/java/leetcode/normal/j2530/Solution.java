package leetcode.normal.j2530;

import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximal-score-after-applying-k-operations/description/">2530. 执行 K 次操作后的最大分数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        for (int num : nums) {
            pq.add(num);
        }
        long ans = 0;
        for (int i = 0; i < k; i++) {
            Integer cur = pq.poll();
            ans += cur;
            pq.add(cur % 3 == 0 ? cur / 3 : (cur / 3 + 1));
        }
        return ans;
    }
}