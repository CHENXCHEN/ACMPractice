package leetcode.normal.j3228;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-number-of-operations-to-move-ones-to-the-end/description/">3228. 将 1 移动到末尾的最大操作次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxOperations(String s) {
        int ans = 0, cnt1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (i > 0 && s.charAt(i - 1) == '1') {
                    ans += cnt1;
                }
            } else ++cnt1;
        }
        return ans;
    }
}