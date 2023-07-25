package leetcode.normal.j2208;

import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-operations-to-halve-array-sum/">2208. 将数组和减半的最少操作次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int halveArray(int[] nums) {
        double opSum = 0, half = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>((x, y) -> y.compareTo(x));
        for (int num : nums) {
            half += 1.0 * num;
            pq.add(1.0 * num);
        }
        opSum = half;
        half /= 2.0;
        int ans = 0;
        while (opSum > half) {
            Double cur = pq.poll();
            opSum -= cur / 2.0;
            pq.add(cur / 2.0);
            ++ans;
        }
        return ans;
    }
}