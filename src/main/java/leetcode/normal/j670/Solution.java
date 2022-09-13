package leetcode.normal.j670;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-swap/">670. 最大交换</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maximumSwap(int num) {
        StringBuffer sb = new StringBuffer(String.valueOf(num));
        for (int i = 0; i < sb.length(); i++) {
            int maxPos = i;
            for (int j = sb.length() - 1; j > i; j--) {
                if (sb.charAt(j) > sb.charAt(maxPos)) {
                    maxPos = j;
                }
            }
            if (sb.charAt(maxPos) > sb.charAt(i)) {
                char ch = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(maxPos));
                sb.setCharAt(maxPos, ch);
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }
}