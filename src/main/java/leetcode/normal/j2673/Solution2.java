package leetcode.normal.j2673;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/make-costs-of-paths-equal-in-a-binary-tree/description/">2673. 使二叉树所有路径值相等的最小代价</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int minIncrements(int n, int[] cost) {
        int ans = 0;
        for (int i = n - 2; i > 0; i -= 2) {
            ans += Math.abs(cost[i] - cost[i + 1]);
            cost[i / 2] += Math.max(cost[i], cost[i + 1]);
        }
        return ans;
    }
}