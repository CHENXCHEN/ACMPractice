package leetcode.normal.j1475;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop/">1475. 商品折扣后的最终价格</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = prices.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && deque.peek() > prices[i]) deque.pop();
            ans[i] = deque.isEmpty() ? prices[i] : prices[i] - deque.peek();
            deque.push(prices[i]);
        }
        return ans;
    }
}