package leetcode.normal.j3304;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-k-th-character-in-string-game-i/description/">3304. 找出第 K 个字符 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public char kthCharacter(int k) {
        k--;
        int cnt = 0;
        // 9 -> 1 -> 0
        // 1001 -> 1 -> 1
        while (k > 0) {
            // 去除 k 的最高位
            k -= Integer.highestOneBit(k);
            ++cnt;
        }
        return (char) ('a' + cnt);
    }
}