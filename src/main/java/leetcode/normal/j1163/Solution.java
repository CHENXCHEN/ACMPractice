package leetcode.normal.j1163;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/last-substring-in-lexicographical-order/">1163. 按字典序排在最后的子串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String lastSubstring(String s) {
        // 最后的答案一定是 s 字符串的某个后缀
        // 因此我们需要比较得出以 [0,n-1] 为坐标开头的最大后缀
        // i 为当前遇到最大的后缀字符串
        int i = 0, n = s.length();
        for (int j = 1, k = 0; j + k < n; ) {
            int d = s.charAt(i + k) - s.charAt(j + k);
            // 如果当前相等，那么代表 s[i,...,i+k] = s[j,...,j+k] 后缀相等
            if (d == 0) ++k;
            else if (d < 0) {
                // 如果 < 0，那么代表 s[i,...,i+k] < s[j,...,j+k]，我们令 i = i + k + 1
                i += k + 1;
                k = 0;
                if (i >= j) j = i + 1;
            } else {
                // 如果 > 0，那么代表 s[i,...,i+k] > s[j,...,j+k]，我们令 i = j + k + 1
                j += k + 1;
                k = 0;
            }
        }
        return s.substring(i);
    }
}