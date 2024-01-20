package leetcode.normal.j2788;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/split-strings-by-separator/description/">2788. 按分隔符拆分字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        ArrayList<String> ans = new ArrayList<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char ch : word.toCharArray()) {
                if (ch == separator) {
                    if (sb.length() > 0) {
                        ans.add(sb.toString());
                        sb = new StringBuilder();
                    }
                } else {
                    sb.append(ch);
                }
            }
            if (sb.length() > 0) {
                ans.add(sb.toString());
            }
        }
        return ans;
    }
}