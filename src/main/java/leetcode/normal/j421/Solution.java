package leetcode.normal.j421;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-xor-of-two-numbers-in-an-array/description/">421. 数组中两个数的最大异或值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        for (int i = 30; i >= 0; i--) {
            Set<Integer> vis = new HashSet<>();
            for (int num : nums) {
                vis.add(num >> i);
            }
            ans = (ans << 1) | 1;
            boolean check = false;
            for (int num : nums) {
                if (vis.contains(ans ^ (num >> i))) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                ans ^= 1;
            }
        }
        return ans;
    }
}