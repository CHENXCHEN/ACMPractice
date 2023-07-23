package leetcode.normal.j42;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode-cn.com/problems/trapping-rain-water/">接雨水</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int trap(int[] height) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!deque.isEmpty() && height[deque.peek()] < height[i]) {
                // 处理栈顶的 高度 * 宽度
                Integer top = deque.pop();
                if (deque.isEmpty()) break;
                // 计算当前 height[top] 可以积水的高度，只计算比 height[top] 大的第一个
                int minHeight = Math.min(height[i], height[deque.peek()]);
                // 计算当前 height[top] 可以积水的最宽宽度
                int len = i - deque.peek() - 1;
                ans += len * (minHeight - height[top]);
            }
            deque.push(i);
        }
        return ans;
    }
}
