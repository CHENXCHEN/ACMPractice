package leetcode.normal.j495;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/teemo-attacking/
 * 495. 提莫攻击
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        int lastStep = 0;
        for (int t : timeSeries) {
            ans += duration;
            if (t < lastStep) ans -= lastStep - t;
            lastStep = t + duration;
        }
        return ans;
    }
}
