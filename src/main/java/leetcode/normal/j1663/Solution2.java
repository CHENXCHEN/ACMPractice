package leetcode.normal.j1663;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/smallest-string-with-a-given-numeric-value/">1663. 具有给定数值的最小字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public String getSmallestString(int n, int k) {
        // 求最小字典序的字符串，它的结构一定为 x1 * a + x2 + x3 * z
        // 转化为公式：
        // x1 * 1 + x2 + x3 * 26 = k
        // x1 + x2 + x3 = n
        // ( 1 <= x2 <= 26)
        // 带入方程解得 x3 = (k - n) / 25
        // 那么继续可得 x1 + x2 = n - x3, x1 + x2 = k - x3 * 26
        // 设剩余的和为 leftSum = k - x3 * 26, leftLen = n - x3
        // 如果 leftLen == leftSum，那么 x1 = leftLen，因为此时刚好全放 a 即可
        // 如果 leftLen < leftSum，那么 x1 = leftLen - 1, x2 = leftSum - x1
        int x1, x2, x3 = (k - n) / 25;
        int leftLen = n - x3, leftSum = k - x3 * 26;
        if (leftSum > leftLen) x1 = leftLen - 1;
        else x1 = leftLen;
        x2 = leftSum - x1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < x1; i++) sb.append('a');
        if (x2 > 0) sb.append((char) ('a' + x2 - 1));
        for (int i = 0; i < x3; i++) sb.append('z');
        return sb.toString();
    }
}