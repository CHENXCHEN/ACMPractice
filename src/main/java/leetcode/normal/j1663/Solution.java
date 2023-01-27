package leetcode.normal.j1663;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/smallest-string-with-a-given-numeric-value/">1663. 具有给定数值的最小字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        // 有两种情况：
        // 1. 全填 z，这种情况下 k = n * z
        // 2. 末尾是 z，这种情况下 k = ${x} * z + ${y} + ${z} * a
        // 先假定除了当前，末尾全是 z 的话，当前应该是多少，当前的可能 < 0 或者 > 0
        // 如果 > 0，那么当前字符直接拿来用就可以
        // 如果 < 0，那么只能用 a
        for (int i = 1, left = (n - 1) * 26; i <= n; i++, left -= 26) {
            // 计算这个位置最小应该放置的字符是什么
            int lower = Math.max(1, k - left);
            k -= lower;
            sb.append((char) ('a' + lower - 1));
        }
        return sb.toString();
    }
}