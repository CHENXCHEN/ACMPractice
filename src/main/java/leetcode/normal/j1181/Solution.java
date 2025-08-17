package leetcode.normal.j1181;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/before-and-after-puzzle/description/">1181. 前后拼接</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        TreeSet<String> treeSet = new TreeSet<>();
        for (int i = 0; i < phrases.length; i++) {
            for (int j = i + 1; j < phrases.length; j++) {
                String w1 = phrases[i], w2 = phrases[j];
                String[] s1 = w1.split(" "), s2 = w2.split(" ");
                if (s1[s1.length - 1].equals(s2[0])) {
                    treeSet.add(buildString(s1, s2));
                }
                if (s1[0].equals(s2[s2.length - 1])) {
                    treeSet.add(buildString(s2, s1));
                }
            }
        }
        return new ArrayList<>(treeSet);
    }

    String buildString(String[] s1, String[] s2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length; i++) {
            sb.append(s1[i]);
            sb.append(" ");
        }
        if (s2.length == 1) {
            sb.delete(sb.length() - 1, sb.length());
        }
        for (int i = 1; i < s2.length; i++) {
            if (i != 1) sb.append(" ");
            sb.append(s2[i]);
        }
        return sb.toString();
    }
}