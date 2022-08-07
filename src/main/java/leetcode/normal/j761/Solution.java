package leetcode.normal.j761;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/special-binary-string/">761. 特殊的二进制序列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String makeLargestSpecial(String s) {
        if (s.length() <= 2) return s;
        ArrayList<String> ans = new ArrayList<>();
        int cnt = 1, left = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (--cnt == 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append('1').append(makeLargestSpecial(s.substring(left + 1, i))).append('0');
                    ans.add(sb.toString());
                    left = i + 1;
                }
            } else cnt += 1;
        }
        ans.sort(Comparator.reverseOrder());
        return String.join("", ans);
    }
}