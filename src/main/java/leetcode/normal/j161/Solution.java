package leetcode.normal.j161;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/one-edit-distance/description/">161. 相隔为 1 的编辑距离</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s.equals(t)) return false;
        int start1 = 0, end1 = s.length() - 1, start2 = 0, end2 = t.length() - 1;
        while (start1 <= end1 && start2 <= end2) {
            if (s.charAt(start1) == t.charAt(start2)) {
                start1++;
                start2++;
            } else if (s.charAt(end1) == t.charAt(end2)) {
                end1--;
                end2--;
            } else break;
        }
        if (s.length() - 1 == t.length()) {
            // s 增加一个字符的情况，start1 == end1
            return start1 == end1;
        } else if (s.length() + 1 == t.length()) {
            // s 删除一个字符的情况，start1 > end1
            return start1 > end1;
        } else if (s.length() == t.length()) {
            // s 替换一个字符的情况，start1 == end1
            return start1 == end1;
        } else return false;
    }
}