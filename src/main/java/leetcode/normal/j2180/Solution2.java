package leetcode.normal.j2180;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-integers-with-even-digit-sum/">2180. 统计各位数字之和为偶数的整数个数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int countEven(int num) {
        if ((num & 1) == 1) return num >> 1;
        int tmp = num, s = 0;
        while (tmp > 0) {
            s += tmp % 10;
            tmp /= 10;
        }
        return (num >> 1) - (s & 1);
    }
}