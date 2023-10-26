package leetcode.normal.j2520;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-the-digits-that-divide-a-number/description/">2520. 统计能整除数字的位数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countDigits(int num) {
        int cur = num, ans = 0;
        while (cur > 0) {
            int x = cur % 10;
            cur /= 10;
            if (x != 0 && num % x == 0) ans++;
        }
        return ans;
    }
}