package leetcode.normal.j2335;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-amount-of-time-to-fill-cups/">2335. 装满杯子需要的最短总时长</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        // 如果 a[2] >= a[0] + a[1]，那么只要把 a[2] 填满，a[0] 和 a[1] 就顺便填满了
        if (amount[2] >= amount[0] + amount[1]) return amount[2];
        // 如果 a[2] < a[0] + a[1]，假设 t = a[0] + a[1] - a[2]，t 为前两个需要的总和
        // 如果 t 为偶数，那么先使得 a[0], a[1] 填满 t/2，那么剩余的为 a[0] + a[1] - t = a[2]，加上 a[2] 可以完全填满
        //    那么答案则为：t/2 + a[2] => (a[0] + a[1] + a[2]) / 2
        // 如果 t 为奇数，那么先使得 a[0], a[1] 填满 (t-1) / 2，那么剩余的则为 a[0] + a[1] - (t - 1) = a[2] + 1，需要加上 a[2] + 1 填满
        //    那么答案则为：(t-1)/2 + a[2] + 1 => (a[0] + a[1] + a[2] + 1) / 2
        // 可以观察到，不管是不是奇偶数，我们 +1 都不会影响计算结果
        return (Arrays.stream(amount).sum() + 1) >> 1;
    }
}