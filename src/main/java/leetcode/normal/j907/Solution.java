package leetcode.normal.j907;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/sum-of-subarray-minimums/">907. 子数组的最小值之和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int sumSubarrayMins(int[] arr) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && arr[deque.peek()] >= arr[i]) deque.pop();
            left[i] = i - (deque.isEmpty() ? -1 : deque.peek());
            deque.push(i);
        }
        deque.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() && arr[deque.peek()] > arr[i]) deque.pop();
            right[i] = (deque.isEmpty() ? n : deque.peek()) - i;
            deque.push(i);
        }
        int mod = 1000000000 + 7;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long) arr[i] * left[i] * right[i] % mod;
            ans %= mod;
        }
        return (int) ans;
    }
}