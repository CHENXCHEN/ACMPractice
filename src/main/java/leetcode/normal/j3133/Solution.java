package leetcode.normal.j3133;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-array-end/description/">3133. 数组最后一个元素的最小值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long minEnd(int n, int x) {
        // and 结果等于 x 的第 n 个数，其实就是 x 的二进制基础上加上 n 的二进制
        // 最大的位数应该不超过 n 的有效位数 + x 的有效位数
        int bitCount = 128 - Long.numberOfLeadingZeros(n) - Long.numberOfLeadingZeros(x);
        long res = x;
        long m = n - 1;
        for (int i = 0, j = 0; i < bitCount; i++) {
            if (((res >> i) & 1) == 0) {
                if (((m >> j) & 1) == 1) {
                    res |= (1L << i);
                }
                ++j;
            }
        }
        return res;
    }
}