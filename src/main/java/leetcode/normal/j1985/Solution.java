package leetcode.normal.j1985;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 * 剑指 Offer 38. 字符串的排列
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {

    void findAll(String s, Set<String> distinctSet, Set<Integer> posSet, StringBuilder ans, int step) {
        if (step == s.length()) {
            distinctSet.add(ans.toString());
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (!posSet.contains(i)) {
                    posSet.add(i);
                    ans.setCharAt(step, s.charAt(i));
                    findAll(s, distinctSet, posSet, ans, step + 1);
                    posSet.remove(i);
                }
            }
        }
    }

    public String[] permutation(String s) {
        Set<String> distinctSet = new TreeSet<>();
        Set<Integer> posSet = new TreeSet<>();
        StringBuilder ans = new StringBuilder(s.length());
        ans.setLength(s.length());
        findAll(s, distinctSet, posSet, ans, 0);
        return distinctSet.toArray(new String[0]);
    }
}
