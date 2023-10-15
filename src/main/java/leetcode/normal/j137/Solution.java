package leetcode.normal.j137;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/single-number-ii/description/">137. 只出现一次的数字 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int singleNumber(int[] nums) {
        int[] cnt = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num >> i & 1) == 1) {
                    cnt[i]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (cnt[i] % 3 != 0) ans |= 1 << i;
        }
        return ans;
    }
}