package leetcode.normal.j1326;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-number-of-taps-to-open-to-water-a-garden/">1326. 灌溉花园的最少水龙头数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int minTaps(int n, int[] ranges) {
        // 每个范围 [start_i, end_i] 中，
        // 对于每个左端点 start_i，我们选择其能包含的最大范围 max(end_i)，可以使得消费最小
        // 然后对于下一个左端点 start_j <= start_i，我们选取能包含的最大范围 max(end_j)，也可以使得消费最小
        int[] rightMost = new int[n + 1];
        for (int i = 0; i < ranges.length; i++) {
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);
            rightMost[start] = Math.max(rightMost[start], end);
        }
        int last = 0, pre = 0, ret = 0;
        for (int i = 0; i < n; i++) {
            last = Math.max(last, rightMost[i]);
            if (last == i) return -1;
            if (pre == i) {
                ++ret;
                pre = last;
            }
        }
        return ret;
    }
}