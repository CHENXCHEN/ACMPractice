package leetcode.normal.j2141;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-running-time-of-n-computers/description/">2141. 同时运行 N 台电脑的最长时间</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int battery : batteries) {
            sum += battery;
        }
        long left = 0, right = sum / n, ans = 0;
        while (left <= right) {
            long mid = (left + right) >> 1;
            long total = 0;
            // 因为一个电池在同一时间只能被1台电脑使用，那么计算在不超过 mid 分钟的情况下，总共能运行多少分钟
            for (int battery : batteries) {
                total += Math.min(mid, battery);
            }
            // 如果总共运行时间 >= n * mid，那么说明可以同时运行 mid 分钟，因为每个电池同一时间只能被1台电脑使用
            // 可以将每个电池根据能源拆分成不超过 mid 的能量为1的小电池，足够给 n 台电脑同时用了
            if (total >= n * mid) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return ans;
    }
}