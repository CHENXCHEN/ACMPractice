package leetcode.normal.j3216;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/lexicographically-smallest-string-after-a-swap/description/">3216. 交换后字典序最小的字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String getSmallestString(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length() - 1; i++) {
            int cur = s.charAt(i) - '0', next = s.charAt(i + 1) - '0';
            if (((cur ^ next) & 1) == 0 && cur > next) {
                sb.setCharAt(i, (char) (next + '0'));
                sb.setCharAt(i + 1, (char) (cur + '0'));
                break;
            }
        }
        return sb.toString();
    }
}