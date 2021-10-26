package leetcode.normal.j496;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/next-greater-element-i/
 * 496. 下一个更大元素 I
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> mAns = new TreeMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int n = nums2[i];
            while (!stack.empty() && stack.peek() < n) {
                stack.pop();
            }
            mAns.put(n, stack.isEmpty() ? -1 : stack.peek());
            stack.push(n);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = mAns.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}