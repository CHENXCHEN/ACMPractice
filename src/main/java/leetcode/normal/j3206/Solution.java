package leetcode.normal.j3206;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/alternating-groups-i/description/">3206. 交替组 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int ans = 0, n = colors.length;
        for (int i = 0; i < n; i++) {
            int pre = (i - 1 + n) % n, next = (i + 1) % n;
            if (colors[i] != colors[next] && colors[i] != colors[pre]) {
                ++ans;
            }
        }
        return ans;
    }
}