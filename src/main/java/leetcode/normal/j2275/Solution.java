package leetcode.normal.j2275;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/largest-combination-with-bitwise-and-greater-than-zero/description/">2275. 按位与结果大于零的最长组合</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int largestCombination(int[] candidates) {
        // idx[i] 表示第 i 位为 1 的数量
        int[] idx = new int[30];
        for (int i = 0; i < candidates.length; i++) {
            int num = candidates[i];
            while (num > 0) {
                int cur = num & -num;
                int bitPos = Integer.numberOfTrailingZeros(cur);
                idx[bitPos]++;
                num -= cur;
            }
        }
        int ans = 1;
        for (int i = 0; i < idx.length; i++) {
            ans = Math.max(ans, idx[i]);
        }
        return ans;
    }
}