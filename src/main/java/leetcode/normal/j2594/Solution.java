package leetcode.normal.j2594;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-time-to-repair-cars/description/">2594. 修车的最少时间</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks);
        long l = 1, r = (long) ranks[ranks.length - 1] * cars * cars, ans = -1;
        while (l <= r) {
            long mid = (l + r) >> 1;
            if (check(ranks, mid) >= cars) {
                ans = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        return ans;
    }

    long check(int[] ranks, long ts) {
        long cnt = 0;
        for (int r : ranks) {
            cnt += (long) Math.sqrt((double) ts / r);
        }
        return cnt;
    }
}