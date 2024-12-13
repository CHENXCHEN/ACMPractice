package leetcode.normal.j17;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/">17. 电话号码的字母组合</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    String[] digit2Str = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> ans;

    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        dfs(digits, 0, new StringBuilder());
        return ans;
    }

    void dfs(String digits, int idx, StringBuilder sb) {
        if (idx == digits.length()) {
            if (sb.length() > 0) ans.add(sb.toString());
            return;
        }
        int pos = digits.charAt(idx) - '0';
        for (int i = 0; i < digit2Str[pos].length(); i++) {
            char ch = digit2Str[pos].charAt(i);
            sb.append(ch);
            dfs(digits, idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}