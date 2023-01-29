package leetcode.normal.j2315;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-asterisks/">2315. 统计星号</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countAsterisks(String s) {
        int ans = 0;
        boolean check = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            check ^= ch == '|';
            if (check && ch == '*') ++ans;
        }
        return ans;
    }
}