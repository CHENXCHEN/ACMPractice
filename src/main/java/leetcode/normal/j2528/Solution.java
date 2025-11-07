package leetcode.normal.j2528;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximize-the-minimum-powered-city/description/">2528. 最大化城市的最小电量</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        // 差分数组
        long[] diff = new long[n + 1];
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - r);
            int right = Math.min(n, i + r + 1);
            diff[left] += stations[i];
            diff[right] -= stations[i];
        }

        long left = Arrays.stream(stations).asLongStream().min().orElse(0L);
        long right = Arrays.stream(stations).asLongStream().sum() + k;
        long ans = 0;
        while (left <= right) {
            long mid = (left + right) >> 1;
            // 每次枚举最大值 mid 是否可以符合
            if (check(diff, mid, r, k)) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return ans;
    }

    boolean check(long[] preDiff, long val, int r, int k) {
        int n = preDiff.length - 1;
        long[] diff = preDiff.clone();
        long sum = 0;
        long remaining = k;
        for (int i = 0; i < n; i++) {
            // 枚举到当前值，如果不符合，那么我们在 i + r 的位置添加，效果最大
            sum += diff[i];
            long add = val - sum;
            if (add < 0) continue;
            if (remaining < add) return false;
            remaining -= add;
            int end = Math.min(n, i + 2 * r + 1);
            diff[end] -= add;
            sum += add;
        }
        return true;
    }
}