package leetcode.normal.j2645;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-additions-to-make-valid-string/description/">2645. 构造有效字符串的最少插入数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int addMinimum(String word) {
        int ans = 0, need = 0;
        for (int i = 0; i < word.length(); i++) {
            int now = word.charAt(i) - 'a';
            if (now == need) {
                need = (now + 1) % 3;
            } else if (need < now) {
                ans += now - need;
                need = (now + 1) % 3;
            } else {
                ans += 3 - need + now;
                need = (now + 1) % 3;
            }
        }
        if (need != 0) ans += 3 - need;
        return ans;
    }
}