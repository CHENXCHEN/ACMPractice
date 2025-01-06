package leetcode.normal.j3019;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-changing-keys/description/">3019. 按键变更的次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countKeyChanges(String s) {
        int ans = 0;
        char last = Character.toLowerCase(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char ch = Character.toLowerCase(s.charAt(i));
            if (ch != last) {
                ++ans;
            }
            last = ch;
        }
        return ans;
    }
}