package leetcode.normal.j816;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/ambiguous-coordinates/description/">816. 模糊坐标</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<String> ambiguousCoordinates(String s) {
        s = s.substring(1, s.length() - 1);
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            List<String> lt = getPos(s.substring(0, i));
            if (lt.isEmpty()) continue;
            List<String> rt = getPos(s.substring(i));
            if (rt.isEmpty()) continue;
            for (String left : lt) {
                for (String right : rt) {
                    StringBuilder sb = new StringBuilder();
                    sb.append('(').append(left).append(", ").append(right).append(')');
                    ans.add(sb.toString());
                }
            }
        }
        return ans;
    }

    List<String> getPos(String s) {
        ArrayList<String> ans = new ArrayList<>();
        if (s.charAt(0) != '0' || s.equals("0")) {
            ans.add(s);
        }
        for (int i = 1; i < s.length(); i++) {
            if ((i != 1 && s.charAt(0) == '0') || s.charAt(s.length() - 1) == '0') continue;
            ans.add(String.format("%s.%s", s.substring(0, i), s.substring(i)));
        }
        return ans;
    }
}