package leetcode.normal.j1850;

import java.util.HashSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-different-integers-in-a-string/">1805. 字符串中不同整数的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numDifferentIntegers(String word) {
        HashSet<String> ss = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (Character.isDigit(word.charAt(i))) {
                if (sb.length() > 0) {
                    if (sb.charAt(0) == '0' && word.charAt(i) != '0') {
                        sb.setCharAt(0, word.charAt(i));
                    } else if (sb.charAt(0) != '0') {
                        sb.append(word.charAt(i));
                    }
                } else sb.append(word.charAt(i));
            } else if (sb.length() > 0) {
                ss.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        if (sb.length() > 0) ss.add(sb.toString());
        return ss.size();
    }
}