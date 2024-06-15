package leetcode.normal.j2813;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-elegance-of-a-k-length-subsequence/description/">2813. 子序列最大优雅度</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long findMaximumElegance(int[][] items, int k) {
        Arrays.sort(items, (int[] x, int[] y) -> y[0] - x[0]);
        long ans = 0, profit = 0;
        int n = items.length;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        Set<Integer> category = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i < k) {
                profit += items[i][0];
                if (!category.add(items[i][1]))
                    deque.push(items[i][0]);
            } else if (!deque.isEmpty() && category.add(items[i][1])) {
                profit += items[i][0] - deque.pop();
            }
            ans = Math.max(ans, profit + (long) category.size() * category.size());
        }
        return ans;
    }
}