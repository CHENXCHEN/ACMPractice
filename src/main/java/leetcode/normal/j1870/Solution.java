package leetcode.normal.j1870;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-speed-to-arrive-on-time/description/">1870. 准时到达的列车最小时速</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 1, right = 10000000, ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (check(dist, hour, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    boolean check(int[] dist, double hour, int speed) {
        double cost = 0;
//        System.out.println("speed: " + speed);
        for (int i = 0; i < dist.length; i++) {
            double res = (double) dist[i] / speed;
            if (i != dist.length - 1) cost += Math.ceil(res);
            else cost += res;
//            System.out.println("cost: " + cost);
        }
        return cost <= hour;
    }
}