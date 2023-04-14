package leetcode.normal.j1023;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/camelcase-matching/">1023. 驼峰式匹配</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        ArrayList<Boolean> ans = new ArrayList<>();
        for (String query : queries) {
            ans.add(check(query, pattern));
        }
        return ans;
    }

    boolean check(String query, String pattern) {
        int pos = 0;
        for (int i = 0; i < query.length(); i++) {
            char queryChar = query.charAt(i);
            boolean isQueryUpper = Character.isUpperCase(queryChar);
            if (isQueryUpper) {
                if (pos >= pattern.length()) return false;
                // 如果 query 是大写，那 patter 是大写的话才合法，否则一定不合法
                if (queryChar == pattern.charAt(pos)) {
                    ++pos;
                } else break;
            } else if (pos < pattern.length() && Character.isLowerCase(pattern.charAt(pos))) {
                // 如果 patter 是小写，那么需要遇到小写的 query 才合法，否则可以作为额外的操作插入
                if (queryChar == pattern.charAt(pos)) {
                    ++pos;
                }
            }
        }
        return pos >= pattern.length();
    }
}