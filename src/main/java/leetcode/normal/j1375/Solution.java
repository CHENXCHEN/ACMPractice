package leetcode.normal.j1375;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-times-binary-string-is-prefix-aligned/">1375. 二进制字符串前缀一致的次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numTimesAllBlue(int[] flips) {
        boolean[] vis = new boolean[flips.length];
        int point = -1, ans = 0;
        for (int i = 0; i < flips.length; i++) {
            // 第 i 次操作过后，[0,i] 区间内的都为 1 的有多少
            vis[flips[i] - 1] = true;
            while (point + 1 < flips.length && vis[point + 1]) ++point;
            if (point >= i) ++ans;
        }
        return ans;
    }
}