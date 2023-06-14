package leetcode.normal.j1375;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-times-binary-string-is-prefix-aligned/">1375. 二进制字符串前缀一致的次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int numTimesAllBlue(int[] flips) {
        int ans = 0, right = 0;
        for (int i = 0; i < flips.length; i++) {
            // 因为题目保证 flips 是 1~n 的排列，因此一个数不会出现两次
            // 如果前 i 次操作之后，flips[0..i] 的最大值不超过 i+1，那么它一定能形成 [0,i] 都为 1 的情况，反之一定不能形成，
            // 因此只需要计算遇到的最大值，再判断即可
            right = Math.max(right, flips[i]);
            if (i + 1 == right) ++ans;
        }
        return ans;
    }
}