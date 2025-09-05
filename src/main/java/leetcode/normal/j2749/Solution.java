package leetcode.normal.j2749;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-operations-to-make-the-integer-zero/description/">2749. 得到整数零需要执行的最少操作数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        // 一次操作之后，是： num1 - 2^i - num2
        for (int i = 0; i <= 60; i++) {
            // 假设操作 i 次，那么实际接下来的操作就是看能不能有 i 次 2^j 加起来等于 num1 - i * num2
            long result = num1 - (long)i * num2;
            // 如果小于 i，那么一定不能操作成功
            if (result < i) return -1;
            // 如果当前可以操作的次数大于 result 中 1 的数量，那么也是可以的
            if (i >= Long.bitCount(result)) return i;
        }
        return -1;
    }
}