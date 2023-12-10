package leetcode.normal.j70;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/climbing-stairs/description/">70. 爬楼梯</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int[] ans = new int[]{1, 2};
        for (int i = 3; i <= n; i++) {
            int cur = ans[0] + ans[1];
            ans[0] = ans[1];
            ans[1] = cur;
        }
        return ans[1];
    }
}