package leetcode.normal.j468;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/validate-ip-address/
 * 468. 验证IP地址
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String validIPAddress(String queryIP) {
        if (isIPV4(queryIP)) return "IPv4";
        else if (isIPV6(queryIP)) return "IPv6";
        return "Neither";
    }

    boolean isIPV4(String str) {
        if (str.indexOf(".") == 0 || str.lastIndexOf(".") == str.length() - 1) return false;
        String[] split = str.split("\\.");
        if (split.length != 4) return false;
        for (String part : split) {
            if (part.length() > 3 || part.length() == 0) {
                return false;
            }
            if (part.charAt(0) == '0' && part.length() > 1) return false;
            for (int i = 0; i < part.length(); i++) {
                char ch = part.charAt(i);
                if (ch < '0' || ch > '9') return false;
            }
            int partInt = Integer.parseInt(part);
            if (partInt < 0 || partInt > 255) return false;
        }
        return true;
    }

    boolean isIPV6(String str) {
        if (str.indexOf(":") == 0 || str.lastIndexOf(":") == str.length() - 1) return false;
        String[] split = str.split(":");
        if (split.length != 8) return false;
        for (String part : split) {
            if (part.length() > 4 || part.length() == 0) return false;
            for (int i = 0; i < part.length(); i++) {
                char ch = Character.toLowerCase(part.charAt(i));
                if ((ch < '0' || ch > '9') && (ch < 'a' || ch > 'f')) {
                    return false;
                }
            }
        }
        return true;
    }
}