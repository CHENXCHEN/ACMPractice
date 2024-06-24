package leetcode.normal.j503;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/next-greater-element-ii/description/">503. 下一个更大元素 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        solve(ans, nums, deque);
        solve(ans, nums, deque);
        return ans;
    }

    void solve(int[] ans, int[] nums, ArrayDeque<Integer> deque) {
        for (int i = 0; i < nums.length; i++) {
            if (deque.isEmpty()) {
                deque.push(i);
            } else {
                while (!deque.isEmpty() && nums[deque.peek()] < nums[i]) {
                    if (ans[deque.peek()] == -1) ans[deque.peek()] = nums[i];
                    deque.pop();
                }
                deque.push(i);
            }
        }
    }
}