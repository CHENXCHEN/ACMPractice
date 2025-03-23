package leetcode.normal.j2116;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/check-if-a-parentheses-string-can-be-valid/description/">2116. 判断一个括号字符串是否有效</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean canBeValid(String s, String locked) {
        // 如果字符串是有效字符串，那么它的所有前缀分数都必须大于等于0
        int n = s.length();
        // 可以达到的最大分数
        int mx = 0;
        // 可以达到的最小分数 与 最小有效前缀对应分数 的较大值
        int mn = 0;
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '1') {
                // 如果有锁定，那么此处的字符只能维持不变
                int diff = s.charAt(i) == '(' ? 1 : -1;
                mx += diff;
                mn = Math.max(mn + diff, (i + 1) % 2);
            } else {
                // 如果没有锁定，那么此处的字符可以任意改
                ++mx;
                mn = Math.max(mn - 1, (i + 1) % 2);
            }
            if (mx < mn) return false;
        }
        return mn == 0;
    }
}