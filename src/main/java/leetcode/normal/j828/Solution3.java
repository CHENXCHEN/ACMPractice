package leetcode.normal.j828;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-unique-characters-of-all-substrings-of-a-given-string/">828. 统计子串中的唯一字符</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution3 {
    public int uniqueLetterString(String s) {
        int ans = 0;
        ArrayList<Integer>[] idx = new ArrayList[26];
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - 'A';
            if (idx[cur] == null) {
                idx[cur] = new ArrayList<>();
                idx[cur].add(-1);
            }
            idx[cur].add(i);
        }
        for (int i = 0; i < 26; i++) {
            if (idx[i] != null) {
                idx[i].add(s.length());
                for (int j = 1; j < idx[i].size() - 1; j++) {
                    ans += (idx[i].get(j) - idx[i].get(j - 1)) * (idx[i].get(j + 1) - idx[i].get(j));
                }
            }
        }
        return ans;
    }
}