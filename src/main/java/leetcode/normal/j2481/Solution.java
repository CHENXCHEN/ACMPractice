package leetcode.normal.j2481;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-cuts-to-divide-a-circle/">2481. 分割圆的最少切割次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numberOfCuts(int n) {
        // 分类讨论
        // 如果是奇数的话，需要画 n 条半径使得切分成 n 份
        // 如果是偶数的话，需要画 n / 2 条直径切分为 n 份
        if (n == 1) return 0;
        if ((n & 1) == 0) return n >> 1;
        return n;
    }
}