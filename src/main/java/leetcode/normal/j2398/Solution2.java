package leetcode.normal.j2398;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-number-of-robots-within-budget/description/">2398. 预算内的最多机器人数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution2 {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        // 单调栈，用于动态维护区间最值
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = chargeTimes.length, ans = 0;
        long runningCostSum = 0;
        for (int i = 0, j = 0; i < n; i++) {
            runningCostSum += runningCosts[i];
            // 将队尾小于等于当前值的都出队列，保证队列头部一定是最大的值
            while (!deque.isEmpty() && chargeTimes[deque.peekLast()] <= chargeTimes[i]) deque.pollLast();
            deque.add(i);
            // 双指针移动，因为对于确定的右端点，长度和答案具备单调性，长度越长，消耗越大
            while (j <= i && (i - j + 1) * runningCostSum + chargeTimes[deque.peek()] > budget) {
                if (!deque.isEmpty() && deque.peek() == j) deque.poll();
                runningCostSum -= runningCosts[j];
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
