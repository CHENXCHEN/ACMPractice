package leetcode.normal.j1130;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-cost-tree-from-leaf-values/">1130. 叶值的最小代价生成树</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int mctFromLeafValues(int[] arr) {
        // 问题可以转化为：给定一个数组 arr，
        // 不断地合并相邻的数，合并代价为两个数的乘积，合并之后的数为两个数的最大值，
        // 直到数组只剩一个数，求最小合并代价和。
        int ans = 0;
        // 维护一个单调栈，这个栈是单调递增的，因为当某个节点被合并后，包含它的子树的最大值不会小于这个节点的值
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int x : arr) {
            while (!deque.isEmpty() && deque.peek() <= x) {
                int y = deque.pop();
                if (deque.isEmpty() || deque.peek() > x) {
                    // 如果栈为空，或者栈顶的元素大于 x，那么选择 y 和 x 进行合并可以使得值更小
                    ans += x * y;
                } else {
                    // 如果栈顶的元素比 x 要小，那么选择跟 y 进行合并可以使得值更小
                    ans += deque.peek() * y;
                }
            }
            deque.push(x);
        }
        // 如果栈内元素大于 2，那么依次去合并剩余的节点
        while (deque.size() >= 2) {
            int x = deque.pop();
            ans += x * deque.peek();
        }
        return ans;
    }
}