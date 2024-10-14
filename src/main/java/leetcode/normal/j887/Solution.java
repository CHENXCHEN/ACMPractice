package leetcode.normal.j887;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/super-egg-drop/description/">887. 鸡蛋掉落</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int superEggDrop(int k, int n) {
        // dp[x][i] 表示当鸡蛋数为 x 时，有 i 层楼的最小尝试次数
        // 对于任意 dp[j][i]，我们选择 1 <= x <= i 的某一层尝试，有两种情况
        //  若第 x 层碎了，那么答案位于 [1, x-1]，答案数为 dp[j-1][x-1]
        //  若第 x 层没碎，那么答案位于 [x+1, n]，答案数为 dp[j][i-x]
        // 所以 dp[j][i] = min(max(dp[j-1][x-1],dp[j][i-x])) + 1
        // 观察可知，dp[j] 具有单调性，随着楼层数增加，那么需要尝试的次数一定增加，所以可以二分
        // 通过二分找到 t1=dp[j-1][x-1] 与 t2=dp[j][i-x] 交叉的左右点
        //  若 t1 > t2，那么需要缩小右端点
        //  若 t1 < t2，那么需要缩小左端点
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 1; i <= n; i++) dp[1][i] = i;
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                int l = 1, r = i;
                while (l + 1 < r) {
                    int mid = (l + r) >> 1;
                    int t1 = dp[j - 1][mid - 1];
                    int t2 = dp[j][i - mid];
                    if (t1 < t2) {
                        l = mid;
                    } else if (t1 > t2) {
                        r = mid;
                    } else {
                        l = r = mid;
                    }
                }
                dp[j][i] = Math.min(Math.max(dp[j - 1][l - 1], dp[j][i - l]), Math.max(dp[j - 1][r - 1], dp[j][i - r])) + 1;
            }
        }
        return dp[k][n];
    }
}