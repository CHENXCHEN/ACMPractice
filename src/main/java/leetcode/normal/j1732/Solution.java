package leetcode.normal.j1732;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-highest-altitude/">1732. 找到最高海拔</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0, sum = 0;
        for (int num: gain) {
            sum += num;
            if (sum > ans) ans = sum;
        }
        return ans;
    }
}