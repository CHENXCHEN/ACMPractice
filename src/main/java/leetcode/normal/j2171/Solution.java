package leetcode.normal.j2171;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/removing-minimum-number-of-magic-beans/description/">2171. 拿出最少数目的魔法豆</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        int n = beans.length;
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + beans[i];
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
//            int cnt = preSum[i] + (preSum[n] - preSum[i] - (n - i) * beans[i]);
            long cnt = preSum[n] - (long) (n - i) * beans[i];
            ans = Math.min(ans, cnt);
        }
        return ans;
    }
}