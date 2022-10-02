package leetcode.normal.j777;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/swap-adjacent-in-lr-string/">777. 在LR字符串中交换相邻字符</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) return false;
        int n = start.length(), i = 0, j = 0;
        // XL -> LX
        // RX -> XR
        while (i < n || j < n) {
            while (i < n && start.charAt(i) == 'X') i++;
            while (j < n && end.charAt(j) == 'X') j++;
            if (i < n && j < n) {
                if (start.charAt(i) != end.charAt(j)) return false;
                else if (start.charAt(i) == 'L' && i < j) return false;
                else if (start.charAt(i) == 'R' && i > j) return false;
            } else if (i < n || j < n) {
                while (i < n && start.charAt(i) == 'X') i++;
                while (j < n && end.charAt(j) == 'X') j++;
                if (i < n || j < n) return false;
            }
            ++i;
            ++j;
        }
        return true;
    }
}