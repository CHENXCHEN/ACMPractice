package leetcode.normal.j3375;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-operations-to-make-array-values-equal-to-k/description/">3375. 使数组的值全部为 K 的最少操作次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minOperations(int[] nums, int k) {
        int[] hash = new int[101];
        for (int num : nums) {
            hash[num]++;
        }
        int ans = 0;
        for (int i = 100; i > 0; i--) {
            if (hash[i] > 0) {
                if (i < k) return -1;
                else if (i != k) ++ans;
            }
        }
        return ans;
    }
}