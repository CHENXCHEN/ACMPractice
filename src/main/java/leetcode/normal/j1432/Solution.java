package leetcode.normal.j1432;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/max-difference-you-can-get-from-changing-an-integer/description/">1432. 改变一个整数能得到的最大差值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxDiff(int num) {
        StringBuilder sb1 = new StringBuilder(String.valueOf(num));
        StringBuilder sb2 = new StringBuilder(String.valueOf(num));
        int minFrom = -1, minTo = -1;
        for (int i = 0; i < sb1.length(); i++) {
            if (sb1.charAt(i) == '1' || sb1.charAt(i) == '0') continue;
            if (minFrom == -1) {
                minFrom = sb1.charAt(i) - '0';
                minTo = i > 0 ? 0 : 1;
            }
            if (sb1.charAt(i) - '0' == minFrom) {
                sb1.setCharAt(i, (char)(minTo + '0'));
            }
        }
        int maxFrom = -1;
        for (int i = 0; i < sb2.length(); i++) {
            if (sb2.charAt(i) == '9') continue;
            if (maxFrom == -1) maxFrom = sb2.charAt(i) - '0';
            if (sb2.charAt(i) - '0' == maxFrom) {
                sb2.setCharAt(i, '9');
            }
        }
        return (int) (Long.parseLong(sb2.toString()) - Long.parseLong(sb1.toString()));
    }
}