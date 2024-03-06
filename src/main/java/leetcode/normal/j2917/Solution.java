package leetcode.normal.j2917;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-k-or-of-an-array/description/">2917. 找出数组中的 K-or 值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findKOr(int[] nums, int k) {
        int[] cnt = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num >> i & 1) == 1) cnt[i]++;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (cnt[i] >= k) ans |= 1 << i;
        }
        return ans;
    }
}