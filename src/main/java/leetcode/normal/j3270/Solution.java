package leetcode.normal.j3270;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-key-of-the-numbers/description/">3270. 求出数字答案</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int generateKey(int num1, int num2, int num3) {
        int ans = 0;
        for (int i = 0, base = 1; i < 4; i++, base *= 10) {
            int cur = Math.min(num1 % 10, Math.min(num2 % 10, num3 % 10));
            ans += cur * base;
            num1 /= 10;
            num2 /= 10;
            num3 /= 10;
        }
        return ans;
    }
}