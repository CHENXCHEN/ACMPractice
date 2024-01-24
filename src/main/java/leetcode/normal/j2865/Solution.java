package leetcode.normal.j2865;

import java.util.ArrayDeque;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/beautiful-towers-i/description/">2865. 美丽塔 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long[] rightSum = new long[n], leftSum = new long[n];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() && maxHeights.get(deque.peek()) > maxHeights.get(i)) {
                deque.pop();
            }
            if (!deque.isEmpty()) {
                rightSum[i] = (long) (deque.peek() - i) * maxHeights.get(i) + rightSum[deque.peek()];
            } else {
                rightSum[i] = (long) (n - i) * maxHeights.get(i);
            }
            deque.push(i);
        }
        deque.clear();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && maxHeights.get(deque.peek()) > maxHeights.get(i)) {
                deque.pop();
            }
            if (!deque.isEmpty()) {
                leftSum[i] = (long) (i - deque.peek()) * maxHeights.get(i) + leftSum[deque.peek()];
            } else {
                leftSum[i] = (long) (i + 1) * maxHeights.get(i);
            }
            deque.push(i);
        }
//        System.out.println("leftSum: " + Arrays.toString(leftSum));
//        System.out.println("rightSum: " + Arrays.toString(rightSum));
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, leftSum[i] + rightSum[i] - maxHeights.get(i));
        }
        return ans;
    }
}