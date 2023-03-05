package leetcode.normal.j982;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/triples-with-bitwise-and-equal-to-zero/description/">982. 按位与为零的三元组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countTriplets(int[] nums) {
        int n = 1 << 16;
        int[] has = new int[n];
        // 计算出任意两个元素 n1 & n2 的结果
        for (int n1 : nums) {
            for (int n2 : nums) {
                has[n1 & n2]++;
            }
        }
        int ans = 0;
        // 枚举当前元素和 任意两个元素 & 的结果为 0 的情况，加起来
        for (int num : nums) {
            for (int i = 0; i < n; i++) {
                if ((num & i) == 0) ans += has[i];
            }
        }
        return ans;
    }
}