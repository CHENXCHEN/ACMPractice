package leetcode.normal.j400;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/nth-digit/
 * 400. 第 N 位数字
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    long calc(long v) {
        long cnt = 1, tmpV = v / 10;
        while (tmpV > 0) {
            cnt++;
            tmpV /= 10;
        }
        long base = 9;
        long ans = 0;
        for (int i = 1; i < cnt; i++) {
            ans += base * i;
            base *= 10;
        }
        ans += (v - (base / 9) + 1) * cnt;
        return ans;
    }

    public int findNthDigit(int n) {
        if (n == 1) return 1;
        long l = 1, r = Integer.MAX_VALUE;
        long res = 0;
        while (l <= r) {
            long m = (l + r) >> 1;
            long mAns = calc(m);
            if (mAns < n) {
                res = m;
                l = m + 1;
            } else r = m - 1;
        }
        int pos = (int)(n - calc(res) - 1);
        return String.valueOf(res + 1).charAt(pos) - '0';
    }
}