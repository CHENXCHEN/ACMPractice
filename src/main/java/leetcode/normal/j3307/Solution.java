package leetcode.normal.j3307;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-k-th-character-in-string-game-ii/description/">3307. 找出第 K 个字符 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public char kthCharacter(long k, int[] operations) {
        k--;
        int offset = 0;
        // 变换路径：9 -> 1 -> 0
        // 变换路径：1001 -> 1 -> 1
        while (k > 0) {
            // 找到当前整数 k 所属的位置，计算要变换的次数
            int highPos = 63 - Long.numberOfLeadingZeros(k);
            // 去除最高位
            k -= Long.highestOneBit(k);
            offset += operations[highPos];
        }
        return (char) ('a' + (offset % 26));
    }
}