package leetcode.normal.j869;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/reordered-power-of-2/
 * 869. 重新排序得到 2 的幂
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int[] getBitCount(int n) {
        int[] ints = new int[10];
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i) - '0']++;
        }
        return ints;
    }


    public boolean reorderedPowerOf2(int n) {
        int[] bitCount = getBitCount(n);
        int maxN = (int) 1e9;
        int res = 1;
        while (res < maxN) {
            if (Arrays.equals(bitCount, getBitCount(res))) return true;
            res <<= 1;
        }
        return false;
    }
}
