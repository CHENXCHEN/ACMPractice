package leetcode.normal.j1108;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/defanging-an-ip-address/
 * 1108. IP 地址无效化
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            char ch = address.charAt(i);
            if (ch == '.') sb.append("[.]");
            else sb.append(ch);
        }
        return sb.toString();
    }
}