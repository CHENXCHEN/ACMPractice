package leetcode.normal.j784;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/letter-case-permutation/">784. 字母大小写全排列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    ArrayList<String> ans = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        dfs(s, 0);
        return ans;
    }

    void dfs(String s, int step) {
        if (step == s.length()) {
            ans.add(s);
            return;
        }
        char ch = s.charAt(step);
        if (Character.isAlphabetic(ch)) {
            StringBuilder sb = new StringBuilder(s);
            sb.setCharAt(step, Character.toUpperCase(ch));
            dfs(sb.toString(), step + 1);
            sb.setCharAt(step, Character.toLowerCase(ch));
            dfs(sb.toString(), step + 1);
        } else {
            dfs(s, step + 1);
        }
    }
}