package leetcode.normal.j3102;

import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimize-manhattan-distances/description/">3102. 最小化曼哈顿距离</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumDistance(int[][] points) {
        // 一些需要知道的前提：曼哈顿距离与切比雪夫距离的相互转化
        // 曼哈顿距离 = |x1 - x2| + |y1 - y2|
        // 可以推导为 = max(|x1 - y1 - (x2 - y2)|, |(x1 + y1) - (x2 + y2)|)
        // 那么只需要考虑这个点集中，两点之差与两点之和 这两种情况中的最小最大值即可
        TreeMap<Integer, Integer> sSub = new TreeMap<>(), sAdd = new TreeMap<>();
        for (int[] point : points) {
            int sub = point[0] - point[1], add = point[0] + point[1];
            sSub.compute(sub, (kk, vv) -> (vv == null ? 0 : vv) + 1);
            sAdd.compute(add, (kk, vv) -> (vv == null ? 0 : vv) + 1);
        }
        int ans = Integer.MAX_VALUE;
        for (int[] point : points) {
            int sub = point[0] - point[1], add = point[0] + point[1];
            sSub.compute(sub, (kk, vv) -> vv - 1 == 0 ? null : vv - 1);
            sAdd.compute(add, (kk, vv) -> vv - 1 == 0 ? null : vv - 1);
            ans = Math.min(ans, Math.max(sSub.lastKey() - sSub.firstKey(), sAdd.lastKey() - sAdd.firstKey()));
            sSub.compute(sub, (kk, vv) -> (vv == null ? 0 : vv) + 1);
            sAdd.compute(add, (kk, vv) -> (vv == null ? 0 : vv) + 1);
        }
        return ans;
    }
}