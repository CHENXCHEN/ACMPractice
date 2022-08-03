package leetcode.normal.j899;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/orderly-queue/">899. 有序队列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution2 {

    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        } else {
            StringBuffer sb = new StringBuffer(s);
            for (int i = 0; i < s.length(); i++) {
                char ch = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(ch);
                String s1 = sb.toString();
                if (s1.compareTo(s) < 0) {
                    s = s1;
                }
            }
            return s;
        }
    }
}
