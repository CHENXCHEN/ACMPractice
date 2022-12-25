package leetcode.normal.j1703;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-adjacent-swaps-for-k-consecutive-ones/description/">1703. 得到连续 K 个 1 的最少相邻交换次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minMoves(int[] nums, int k) {
        // 假设 q[i] 为第 i 个 1 所在的位置
        // 那么我们需要枚举所有的长度为 k 的 1 的下标，假设我们枚举到了 i...(i+k-1)
        // 我们需要计算 q[i...(i+k-1)] 这些 1 的位置的最小花费
        // 我们要找到 x，使得表达式的结果最小：|q[i]-(x+i)| + ... + |q[i+k-1]-(x+i-k+1)|
        // 转换表达式 => |q[i]-i - x| + ... + |q[i+k-1]-(i+k-1) - x|
        // 假设 p[i] = q[i] - i
        // 则 需要求 |p[i] - x| + ... + |p[i+k-1] - x|
        // 取 p[i] 的中位数则可以使得这个表达式值最小
        ArrayList<Integer> p = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0) p.add(i - p.size());
        int m = p.size();
        int[] preSum = new int[m + 1];
        for (int i = 0; i < m; i++) preSum[i + 1] = preSum[i] + p.get(i);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= m - k; i++)
            ans = Math.min(ans, preSum[i] + preSum[i + k] - (preSum[i + (k >> 1)] << 1) - (p.get(i + (k >> 1)) * (k & 1)));
        return ans;
    }
}