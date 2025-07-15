package leetcode.normal.j3136;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/valid-word/description/">3136. 有效单词</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean isValid(String word) {
        boolean yuan = false, fu = false, shu = false;
        for (int i = 0; i < word.length(); i++) {
            char c = Character.toLowerCase(word.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                yuan = true;
            } else if (c >= 'a' && c <= 'z') {
                fu = true;
            } else if (c >= '0' && c <= '9') {
                shu = true;
            } else return false;
        }
        int ans = 0;
        if (word.length() >= 3) ++ans;
        if (yuan) ++ans;
        if (fu) ++ans;
        if (shu || fu || yuan) ++ans;
        return ans == 4;
    }
}