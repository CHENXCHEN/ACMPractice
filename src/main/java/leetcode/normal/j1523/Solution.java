package leetcode.normal.j1523;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-odd-numbers-in-an-interval-range/description/">1523. 在区间范围内统计奇数数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countOdds(int low, int high) {
        return getOddCnt(high) - getOddCnt(low - 1);
    }

    // 获取 <=n 的奇数数量
    int getOddCnt(int n) {
        return (n + 1) / 2;
    }
}