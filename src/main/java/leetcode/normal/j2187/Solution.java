package leetcode.normal.j2187;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-time-to-complete-trips/description/">2187. 完成旅途的最少时间</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long left = 1, right = (long) totalTrips * time[0], ans = 1L;
        while (left <= right) {
            long mid = (left + right) >> 1;
            long trips = checkTripsInTime(time, mid);
            if (trips >= totalTrips) {
                ans = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return ans;
    }

    long checkTripsInTime(int[] time, long target) {
        long ans = 0;
        for (int i = 0; i < time.length; i++) {
            ans += target / time[i];
        }
        return ans;
    }
}