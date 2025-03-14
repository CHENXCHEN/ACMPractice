package leetcode.normal.j3340;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/check-balanced-string/description/">3340. 检查平衡字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean isBalanced(String num) {
        int ans = 0;
        for (int i = 0; i < num.length(); i++) {
            int cur = num.charAt(i) - '0';
            ans += (i % 2 == 0 ? cur : -cur);
        }
        return ans == 0;
    }
}