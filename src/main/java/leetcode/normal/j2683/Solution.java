package leetcode.normal.j2683;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/neighboring-bitwise-xor/description/">2683. 相邻值的按位异或</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        // a[0], a[1], a[2]
        // b[0] = a[0]^a[1]
        // b[1] = a[1]^a[2]
        // b[2] = a[2]^a[0]
        int first = 0, last = 0;
        for (int i = 0; i < derived.length; i++) {
            last ^= derived[i];
        }
        return last == first;
    }
}