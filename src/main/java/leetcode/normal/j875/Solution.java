package leetcode.normal.j875;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/koko-eating-bananas/
 * 875. 爱吃香蕉的珂珂
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int pile : piles) {
            if (pile > right) right = pile;
        }
        int ans = right;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int hour = finishHour(piles, mid);
            // pile / mid = hour
            if (hour <= h) {
                ans = Math.min(mid, ans);
                right = mid - 1;
            } else left = mid + 1;
        }
        return ans;
    }

    int finishHour(int[] piles, int rate) {
        int ans = 0;
        for (int pile : piles) {
            ans += pile / rate;
            if (pile % rate != 0) ans++;
        }
        return ans;
    }
}