package leetcode.normal.j3403;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-lexicographically-largest-string-from-the-box-i/description/">3403. 从盒子中找出字典序最大的字符串 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) return word;
        int n = word.length(), m = n - numFriends + 1;
        String ans = "";
        for (int i = 0; i < n; i++) {
            String substring = word.substring(i, Math.min(i + m, n));
            if (substring.compareTo(ans) > 0) {
                ans = substring;
            }
        }
        return ans;
    }
}
