package leetcode.normal.j1295;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-numbers-with-even-number-of-digits/description/">1295. 统计位数为偶数的数字</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            if (getDigit(num) % 2 == 0) ++ans;
        }
        return ans;
    }

    int getDigit(int num) {
        int cnt = 0;
        while (num > 0) {
            ++cnt;
            num /= 10;
        }
        return cnt;
    }
}