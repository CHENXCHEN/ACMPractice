package leetcode.normal.j2437;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-valid-clock-times/">2437. 有效时间的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countTime(String time) {
        int[] ts = {time.charAt(0), time.charAt(1), time.charAt(3), time.charAt(4)};
        int ansHour = 0, ansMinute = 0;
        for (int i0 = 0; i0 <= 9; i0++) {
            if (isNotSame(ts[0], '0' + i0)) continue;
            for (int i1 = 0; i1 <= 9; i1++) {
                if (isNotSame(ts[1], '0' + i1)) continue;
                int hour = i0 * 10 + i1;
                if (hour >= 24) break;
                ++ansHour;
            }
        }
        for (int i2 = 0; i2 <= 9; i2++) {
            if (isNotSame(ts[2], '0' + i2)) continue;
            for (int i3 = 0; i3 <= 9; i3++) {
                if (isNotSame(ts[3], '0' + i3)) continue;
                int minute = i2 * 10 + i3;
                if (minute >= 60) break;
                ++ansMinute;
            }
        }
        return ansHour * ansMinute;
    }

    boolean isNotSame(int ch, int other) {
        if (ch == '?') return false;
        return ch != other;
    }
}