package leetcode.normal.j2337;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/move-pieces-to-obtain-a-string/">2337. 移动片段得到字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean canChange(String start, String target) {
        int i = 0, j = 0;
        while (i < start.length() && j < target.length()) {
            while (i < start.length() && start.charAt(i) == '_') ++i;
            while (j < target.length() && target.charAt(j) == '_') ++j;
            if (i < start.length() && j < start.length()) {
                if (start.charAt(i) != target.charAt(j)) return false;
                if (start.charAt(i) == 'L') {
                    if (i < j) return false;
                } else if (start.charAt(i) == 'R') {
                    if (i > j) return false;
                }
                ++i;
                ++j;
            } else {
                return i == start.length() && j == target.length();
            }
        }
        while (i < start.length() && start.charAt(i) == '_') ++i;
        while (j < target.length() && target.charAt(j) == '_') ++j;
        return i == start.length() && j == target.length();
    }
}