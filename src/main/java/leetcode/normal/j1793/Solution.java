package leetcode.normal.j1793;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-score-of-a-good-subarray/description/">1793. 好子数组的最大分数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maximumScore(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] rLeft = new int[n], rRight = new int[n];
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && nums[deque.peek()] >= nums[i]) {
                deque.poll();
            }
            rLeft[i] = deque.isEmpty() ? 0 : deque.peek() + 1;
            deque.push(i);
        }
        deque.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() && nums[deque.peek()] >= nums[i]) {
                deque.poll();
            }
            rRight[i] = deque.isEmpty() ? n - 1 : deque.peek() - 1;
            deque.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int l = rLeft[i], r = rRight[i];
            if (l <= k && k <= r) {
//                System.out.println("i: " + i + " l: " + l + " r: " + r + " res: " + ((r - l + 1) * nums[i]));
                ans = Math.max(ans, (r - l + 1) * nums[i]);
            }
        }
        return ans;
    }
}