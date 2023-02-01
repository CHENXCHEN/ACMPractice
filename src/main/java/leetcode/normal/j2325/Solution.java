package leetcode.normal.j2325;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/decode-the-message/">2325. 解密消息</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String decodeMessage(String key, String message) {
        char[] has = new char[123];
        char cur = 'a';
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (ch != ' ' && has[ch] == 0) {
                has[ch] = cur++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (ch != ' ') {
                sb.append(has[ch]);
            } else sb.append(' ');
        }
        return sb.toString();
    }
}