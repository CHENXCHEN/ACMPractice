package leetcode.normal.j158;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/read-n-characters-given-read4-ii-call-multiple-times/description/">158. 用 Read4 读取 N 个字符 II - 多次调用</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution extends Reader4 {
    StringBuilder sb = new StringBuilder();
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    public int read(char[] buf, int n) {
        while (sb.length() < n) {
            char[] tmp = new char[4];
            int cnt = read4(tmp);
            for (int i = 0; i < cnt; i++) {
                sb.append(tmp[i]);
            }
            if (cnt == 0) break;
        }
        int idx = 0;
        while (sb.length() > 0 && idx < n) {
            buf[idx++] = sb.charAt(0);
            sb.deleteCharAt(0);
        }
        return idx;
    }
}