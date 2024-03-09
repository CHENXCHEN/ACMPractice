package leetcode.normal.j2386;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-k-sum-of-an-array/description/">2386. 找出数组的第 K 大和</a>
 * 相关题单：https://leetcode.cn/problems/find-the-k-sum-of-an-array/solutions/1764389/zhuan-huan-dui-by-endlesscheng-8yiq/
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long kSum(int[] nums, int k) {
        long tot = 0;
        int n = nums.length;
        // 假定 tot 表示为非负数之和，tot_neg 表示为负数之和
        // 将负数转换为绝对值，那么它的第 k 小序列之和为 sk，
        // sk + tot_neg 也可以表示为原序列的某个子序列之和，而 tot_neg 为常数，因此 sk + tot_neg 是非递减的，也是第 k 小的序列
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) tot += nums[i];
            else nums[i] = -nums[i];
        }
        Arrays.sort(nums);
        long ret = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>((x, y) -> Long.compare(x[0], y[0]));
        pq.add(new long[]{nums[0], 0});
        for (int j = 2; j <= k; j++) {
            long[] poll = pq.poll();
            ret = poll[0];
            int i = (int) poll[1];
            if (i == n - 1) continue;
            pq.add(new long[]{ret + nums[i + 1], i + 1});
            pq.add(new long[]{ret - nums[i] + nums[i + 1], i + 1});
        }
        return tot - ret;
    }
}