package leetcode.normal.lcp30;

import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/p0NxJO/description/">LCP 30. 魔塔游戏</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int magicTower(int[] nums) {
        long tot = 1, negTot = 0;
        int adjCnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            tot += nums[i];
            if (nums[i] < 0) pq.add(nums[i]);
            while (!pq.isEmpty() && tot <= 0) {
                Integer poll = pq.poll();
                tot -= poll;
                ++adjCnt;
                negTot += poll;
            }
        }
        if (tot + negTot > 0) return adjCnt;
        return -1;
    }
}