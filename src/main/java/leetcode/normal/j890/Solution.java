package leetcode.normal.j890;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/find-and-replace-pattern/
 * 890. 查找和替换模式
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        ArrayList<String> ans = new ArrayList<>();
        for (String word : words) {
            if (isPattern(word, pattern)) ans.add(word);
        }
        return ans;
    }

    boolean isPattern(String str, String pattern) {
        int[] has = new int[26];
        boolean[] isBeMap = new boolean[26];
        Arrays.fill(has, -1);
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i) - 'a';
            int p = pattern.charAt(i) - 'a';
            if (has[p] == -1 && !isBeMap[c]) {
                has[p] = c;
                isBeMap[c] = true;
            } else if (has[p] != c) return false;
        }
        return true;
    }
}