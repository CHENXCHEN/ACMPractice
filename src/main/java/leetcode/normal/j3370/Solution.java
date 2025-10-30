package leetcode.normal.j3370;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/smallest-number-with-all-set-bits/description/">3370. 仅含置位位的最小整数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int smallestNumber(int n) {
       int highest = Integer.highestOneBit(n);
       return (highest << 1) - 1;
    }
}