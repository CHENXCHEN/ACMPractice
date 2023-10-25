package leetcode.normal.j2698;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-punishment-number-of-an-integer/description/">2698. 求一个整数的惩罚数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dfs(String.valueOf(i * i), 0, 0, i)) {
                ans += i * i;
            }
        }
        return ans;
    }

    boolean dfs(String s, int pos, int tot, int target) {
        if (s.length() == pos) return tot == target;
        int sum = 0;
        for (int i = pos; i < s.length(); i++) {
            sum = sum * 10 + (s.charAt(i) - '0');
            if (tot + sum > target) break;
            if (dfs(s, i + 1, tot + sum, target)) {
                return true;
            }
        }
        return false;
    }
}