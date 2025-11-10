package leetcode.normal.j3542;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-operations-to-convert-all-elements-to-zero/description/">3542. 将所有元素变为 0 的最少操作次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int minOperations(int[] nums) {
        int ans = 0;
        // 单调栈，维护一个单调递减的，枚举每一个元素，看是否要操作，将比当前元素大的都移除，移除之后，如果栈顶比当前元素小，那么当前必定要+1，如果相等，可以不操作
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int num : nums) {
            while (!stack.isEmpty() && num < stack.peek()) {
                stack.pop();
            }
            if (num == 0) continue;
            if (stack.isEmpty() || num > stack.peek()) {
                ++ans;
                stack.push(num);
            }
        }
        return ans;
    }
}