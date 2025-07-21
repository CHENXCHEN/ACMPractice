package leetcode.normal.j1957;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/delete-characters-to-make-fancy-string/description/"></a>
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String makeFancyString(String s) {
        int ans = 0, cnt = 0;
        char last = ' ';
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == last) {
                ++cnt;
            } else {
                last = ch;
                cnt = 1;
            }
            if (cnt >= 3) {
                ++ans;
                --cnt;
            } else {
                sb.append(last);
            }
        }
        return sb.toString();
    }
}