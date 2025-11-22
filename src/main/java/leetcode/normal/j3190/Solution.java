package leetcode.normal.j3190;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/description/">3190. 使所有元素都可以被 3 整除的最少操作数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumOperations(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            int left = num % 3;
            ans += Math.min(left, 3 - left);
        }
        return ans;
    }
}