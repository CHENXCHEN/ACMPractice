package leetcode.normal.j2575;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-divisibility-array-of-a-string/description/">2575. 找出字符串的可整除数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] divisibilityArray(String word, int m) {
        long res = 0;
        int[] ans = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            res = (res * 10 + (word.charAt(i) - '0')) % m;
            if (res == 0) ans[i] = 1;
        }
        return ans;
    }
}