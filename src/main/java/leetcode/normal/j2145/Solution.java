package leetcode.normal.j2145;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-the-hidden-sequences/description/">2145. 统计隐藏数组数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long minSum = 0, maxSum = 0, cur = 0;
        for (int diff : differences) {
            cur += diff;
            minSum = Math.min(cur, minSum);
            maxSum = Math.max(cur, maxSum);
        }
        long cnt0 = maxSum - minSum + 1, cnt1 = upper - lower + 1;
        if (cnt0 <= cnt1) return (int)(cnt1 - cnt0 + 1);
        else return 0;
    }
}