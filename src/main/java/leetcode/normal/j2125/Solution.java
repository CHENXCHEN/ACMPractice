package leetcode.normal.j2125;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-laser-beams-in-a-bank/description/">2125. 银行中的激光束数量</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numberOfBeams(String[] bank) {
        int rows = bank.length, cols = bank[0].length();
        int ans = 0, last = 0;
        for (int i = 0; i < rows; i++) {
            int cnt = 0;
            for (int j = 0; j < cols; j++) {
                if (bank[i].charAt(j) == '1') ++cnt;
            }
            if (cnt > 0) {
                ans += last * cnt;
                last = cnt;
            }
        }
        return ans;
    }
}