package leetcode.normal.j3158;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-xor-of-numbers-which-appear-twice/description/">3158. 求出出现两次数字的 XOR 值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int[] cnt = new int[51];
        for (int num : nums) {
            cnt[num]++;
        }
        int ans = 0;
        for (int i = 1; i <= 50; i++) {
            if (cnt[i] == 2) ans ^= i;
        }
        return ans;
    }
}