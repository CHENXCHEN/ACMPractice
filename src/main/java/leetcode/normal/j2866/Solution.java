package leetcode.normal.j2866;

import java.util.ArrayDeque;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/beautiful-towers-ii/description/">2866. 美丽塔 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = maxHeights.size();
        long[] leftSum = new long[n], rightSum = new long[n];
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && maxHeights.get(deque.peek()) > maxHeights.get(i)) {
                deque.poll();
            }
            if (deque.isEmpty()) {
                leftSum[i] = (long) maxHeights.get(i) * (i + 1);
            } else {
                leftSum[i] = (long) maxHeights.get(i) * (i - deque.peek()) + leftSum[deque.peek()];
            }
            deque.push(i);
        }
        deque.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() && maxHeights.get(deque.peek()) > maxHeights.get(i)) {
                deque.poll();
            }
            if (deque.isEmpty()) {
                rightSum[i] = (long) maxHeights.get(i) * (n - i);
            } else {
                rightSum[i] = (long) maxHeights.get(i) * (deque.peek() - i) + rightSum[deque.peek()];
            }
            deque.push(i);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, leftSum[i] + rightSum[i] - maxHeights.get(i));
        }
        return ans;
    }
}