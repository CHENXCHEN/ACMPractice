package leetcode.normal.j1750;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-length-of-string-after-deleting-similar-ends/">1750. 删除字符串两端相同字符后的最短长度</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumLength(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) break;
            char first = s.charAt(i);
            while (i < j && s.charAt(i) == first) ++i;
            while (i < j && s.charAt(j) == first) --j;
            if (i == j && s.charAt(i) == first) return 0;
        }
        return j - i + 1;
    }
}