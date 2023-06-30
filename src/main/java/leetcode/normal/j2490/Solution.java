package leetcode.normal.j2490;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/circular-sentence/">2490. 回环句</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] strs = sentence.split(" ");
        int n = strs.length;
        if (strs[0].charAt(0) != strs[n - 1].charAt(strs[n - 1].length() - 1)) return false;
        for (int i = 0; i < n - 1; i++) {
            if (strs[i].charAt(strs[i].length() - 1) != strs[i + 1].charAt(0)) {
                return false;
            }
        }
        return true;
    }
}