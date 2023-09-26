package leetcode.normal.j2582;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/pass-the-pillow/description/">2582. 递枕头</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int passThePillow(int n, int time) {
        int round = (n - 1) << 1;
        time %= round;
        if (time <= n - 1) {
            return 1 + time;
        } else {
            time -= n - 1;
            return n - time;
        }
    }
}