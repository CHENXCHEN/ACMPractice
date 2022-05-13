package leetcode.normal.j2530;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/one-away-lcci/
 * 面试题 01.05. 一次编辑
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            int diffCnt = 0;
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    diffCnt++;
                    if (diffCnt >= 2) return false;
                }
            }
            return true;
        } else if (Math.abs(first.length() - second.length()) == 1) {
            int firstPos = 0, secondPos = 0;
            while (firstPos < first.length() && secondPos < second.length() && first.charAt(firstPos) == second.charAt(secondPos)) {
                firstPos++;
                secondPos++;
            }
            if (firstPos == first.length() || secondPos == second.length()) return true;
            if (first.length() > second.length()) firstPos++;
            else secondPos++;
            while (firstPos < first.length() && secondPos < second.length() && first.charAt(firstPos) == second.charAt(secondPos)) {
                firstPos++;
                secondPos++;
            }
            return firstPos == first.length() && secondPos == second.length();
        } else return false;
    }
}