package leetcode.normal.j3226;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-bit-changes-to-make-two-integers-equal/description/">3226. 使两个整数相等的位更改次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minChanges(int n, int k) {
        int ans = 0;
        for (int i = 20; i >= 0; i--) {
            boolean bit1 = ((n >> i) & 1) == 1;
            boolean bit2 = ((k >> i) & 1) == 1;
            if (bit1 && !bit2) ++ans;
            if (!bit1 && bit2) return -1;
        }
        return ans;
    }
}