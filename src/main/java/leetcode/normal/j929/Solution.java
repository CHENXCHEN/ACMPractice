package leetcode.normal.j929;

import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/unique-email-addresses/
 * 929. 独特的电子邮件地址
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numUniqueEmails(String[] emails) {
        TreeSet<String> tSet = new TreeSet<>();
        for (String email : emails) {
            tSet.add(getEmail(email));
        }
        return tSet.size();
    }

    String getEmail(String email) {
        String[] split = email.split("@");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split[0].length(); i++) {
            char ch = split[0].charAt(i);
            if (ch == '+') break;
            if (ch == '.') continue;
            sb.append(ch);
        }
        sb.append("@").append(split[1]);
        return sb.toString();
    }
}