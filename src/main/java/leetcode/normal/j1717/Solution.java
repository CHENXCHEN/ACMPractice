package leetcode.normal.j1717;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-score-from-removing-substrings/description/">1717. 删除子字符串的最大得分</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maximumGain(String s, int x, int y) {
        // 如果 x < y，就把 x, y 进行交换，并且把 a 和 b 字符也进行交换，统一转换为优先处理 ab 的情况
        if (x < y) {
            int tmp = x;
            x = y;
            y = tmp;
            s = s.replace('a', '\0').replace('b', 'a').replace('\0', 'b');
        }
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int cntA = 0, cntB = 0;
            while (i < s.length() && (s.charAt(i) == 'a' || s.charAt(i) == 'b')) {
                char c = s.charAt(i++);
                if (c == 'a') ++cntA;
                else {
                    if (cntA > 0) {
                        cntA--;
                        ans += x;
                    } else {
                        cntB++;
                    }
                }
            }
            // 如果 cntB > 0，那么此时的 cntA 指的 a，一定是在 b 后面的
            ans += Math.min(cntA, cntB) * y;
        }
        return ans;
    }
}