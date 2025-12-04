package leetcode.normal.j3623;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-number-of-trapezoids-i/description/">3623. 统计梯形的数目 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countTrapezoids(int[][] points) {
        int MOD = (int) 1e9 + 7;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] point : points) {
            map.compute(point[1], (key, val) -> val == null ? 1 : (val + 1));
        }
        // sum 是计算除了当前边以外，可以组成的边的数量，当前边的数量 * 之前的边的数量 = 当前可以组成平行梯形的数量
        long sum = 0, ans = 0;
        for (Integer value : map.values()) {
            long edge = (long) value * (value - 1) / 2;
            ans = (ans + edge * sum) % MOD;
            sum = (sum + edge) % MOD;
        }
        return (int) ans;
    }
}