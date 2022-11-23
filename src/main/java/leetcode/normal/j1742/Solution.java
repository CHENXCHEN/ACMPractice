package leetcode.normal.j1742;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-number-of-balls-in-a-box/">1742. 盒子中小球的最大数量</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int[] cnt = new int[48];
        for (int i = lowLimit; i <= highLimit; i++) {
            cnt[getCnt(i)]++;
        }
        return Arrays.stream(cnt).max().getAsInt();
    }

    int getCnt(int vv) {
        int ans = 0;
        while (vv > 0) {
            ans += vv % 10;
            vv /= 10;
        }
        return ans;
    }
}