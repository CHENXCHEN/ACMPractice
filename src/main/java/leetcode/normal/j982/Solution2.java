package leetcode.normal.j982;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/triples-with-bitwise-and-equal-to-zero/description/">982. 按位与为零的三元组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int countTriplets(int[] nums) {
        int[] has = new int[1 << 16];
        // 计算出任意两个元素 n1 & n2 的结果
        for (int n1 : nums) {
            for (int n2 : nums) {
                has[n1 & n2]++;
            }
        }
        int ans = 0;
        // 枚举当前元素和 任意两个元素 & 的结果为 0 的情况，加起来
        for (int num : nums) {
            // 如果 num 的第 i 个二进制为 1，那么另外两个数&操作结果的第 i 位必须为 0
            // 如果 num 的第 i 个二进制为 0，那么另外两个数&操作结果的第 i 位可以为 0 或 1
            // 异或之后，得到的数，我们需要枚举出所有 1 的子集，加起来就可以了
            int rev = num ^ 0xffff;
            // 枚举符合与 num & 操作等于 0 的所有子集
            for (int x = rev; x > 0; x = (x - 1) & rev) {
                ans += has[x];
            }
            ans += has[0];
        }
        return ans;
    }
}