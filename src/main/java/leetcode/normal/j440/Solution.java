package leetcode.normal.j440;

/**
 * Created by CHENXCHEN
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while (k > 0) {
            int steps = getSteps(cur, n);
            if (steps <= k) {
                // 如果 cur 的子树节点数目 <= k，那么可以跳过当前子树，进入下一个子树
                k -= steps;
                cur++;
            } else {
                // 如果 cur 的子树节点 > k，那么往子树开始搜索
                cur *= 10;
                k--;
            }
        }
        return cur;
    }

    int getSteps(int cur, int n) {
        int steps = 0;
        long first = cur, last = cur;
        while (first <= n) {
            steps += Math.min(last, n) - first + 1;
            // 进入下一层
            first = first * 10;
            last = last * 10 + 9;
        }
        return steps;
    }
}