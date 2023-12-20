package leetcode.normal.j2828;

import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/check-if-a-string-is-an-acronym-of-words/description/">2828. 判别首字母缩略词</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean isAcronym(List<String> words, String s) {
        if (s.length() != words.size()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != words.get(i).charAt(0)) return false;
        }
        return true;
    }
}