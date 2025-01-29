package leetcode.normal.j157;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/">157. 用 Read4 读取 N 个字符</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int pos = 0;
        char[] buf4 = new char[4];
        while (pos < n) {
            int len = read4(buf4);
            for (int i = 0; i < len && pos < n; i++, pos++) {
                buf[pos] = buf4[i];
            }
            if (pos >= n) break;
            if (len < 4) break;
        }
        return pos;
    }
}