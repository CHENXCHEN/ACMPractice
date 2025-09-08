package leetcode.normal.j1317;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/convert-integer-to-the-sum-of-two-no-zero-integers/description/">1317. 将整数转换为两个无零整数的和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n; i++) {
            int j = n - i;
            if (isValid(i) && isValid(j)) {
                return new int[]{i, j};
            }
        }
        return new int[]{0, 0};
    }

    boolean isValid(int num) {
        while (num > 0) {
            if (num % 10 == 0) return false;
            num /= 10;
        }
        return true;
    }
}