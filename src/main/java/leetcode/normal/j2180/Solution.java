package leetcode.normal.j2180;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-integers-with-even-digit-sum/">2180. 统计各位数字之和为偶数的整数个数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countEven(int num) {
        int cnt = 0;
        for (int i = 1; i <= num; i++) {
            if (check(i)) ++cnt;
        }
        return cnt;
    }

    boolean check(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt += n % 10;
            n /= 10;
        }
        return (cnt & 1) == 0;
    }
}