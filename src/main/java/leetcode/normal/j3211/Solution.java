package leetcode.normal.j3211;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/generate-binary-strings-without-adjacent-zeros/description/">3211. 生成不含相邻零的二进制字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<String> validStrings(int n) {
        ArrayList<String> ans = new ArrayList<>();
        dfs(new StringBuilder(), n, ans);
        return ans;
    }

    void dfs(StringBuilder sb, int limit, ArrayList<String> ans) {
        if (sb.length() == limit) {
            ans.add(sb.toString());
            return;
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '0') {
            sb.append('1');
            dfs(sb, limit, ans);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append('0');
            dfs(sb, limit, ans);
            sb.setCharAt(sb.length() - 1, '1');
            dfs(sb, limit, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}