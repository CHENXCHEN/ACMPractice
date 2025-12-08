package leetcode.normal.j1925;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-square-sum-triples/description/">1925. 统计平方和三元组的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countTriples(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int k = i * i + j * j;
                int sqrt = (int) Math.sqrt(k);
                if (sqrt <= n && sqrt * sqrt == k) {
                    ans ++;
                    if (i != j) ans++;
                }
            }
        }
        return ans;
    }
}