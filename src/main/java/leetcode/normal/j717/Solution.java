package leetcode.normal.j717;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/1-bit-and-2-bit-characters/description/">717. 1 比特与 2 比特字符</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == 1) {
                i++;
            } else if (i == bits.length - 1) {
                return true;
            }
        }
        return false;
    }
}