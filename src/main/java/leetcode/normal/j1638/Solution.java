package leetcode.normal.j1638;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-substrings-that-differ-by-one-character/">1638. 统计只差一个字符的子串数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countSubstrings(String s, String t) {
        int ans = 0;
        int n = s.length(), m = t.length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int diffCnt = 0;
                for (int k = 0; i + k < n && j + k < m; k++) {
                    diffCnt += s.charAt(i + k) == t.charAt(j + k) ? 0 : 1;
                    if (diffCnt > 1) break;
                    else if (diffCnt == 1) ++ans;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.countSubstrings("ab", "bb");
    }
}