package leetcode.normal.j520;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/detect-capital/
 * 520. 检测大写字母
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean detectCapitalUse(String word) {
        int upperCnt = 0, lowerCnt = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isUpperCase(ch)) upperCnt++;
            else lowerCnt++;
        }
        return upperCnt == word.length() || lowerCnt == word.length() || (Character.isUpperCase(word.charAt(0)) && lowerCnt == word.length() - 1);
    }
}
