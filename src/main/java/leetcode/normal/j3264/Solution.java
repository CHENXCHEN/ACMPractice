package leetcode.normal.j3264;

import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/final-array-state-after-k-multiplication-operations-i/description/">3264. K 次乘运算后的最终数组 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> nums[x] != nums[y] ? nums[x] - nums[y] : x - y);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            pq.add(i);
        }
        for (int i = 0; i < k; i++) {
            Integer pos = pq.poll();
            nums[pos] *= multiplier;
            pq.add(pos);
        }
        return nums;
    }
}