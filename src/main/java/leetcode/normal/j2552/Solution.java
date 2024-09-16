package leetcode.normal.j2552;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-increasing-quadruplets/description/">2552. 统计上升四元组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long countQuadruplets(int[] nums) {
        int n = nums.length;
        // 记录比 x 小的数字有多少
        int[] pre = new int[n + 1];
        long ans = 0;
        for (int j = 0; j < n; j++) {
            // 找到符合 a[i] < a[j] 的对数 以及 a[k] < a[l] 的对数，在满足 a[k] < a[j] < a[l] 时，两者相乘就是答案
            // suf 表示为 a[j] < a[l] 的对数
            int suf = 0;
            for (int k = n - 1; k > j; k--) {
                if (nums[j] > nums[k]) {
                    ans += (long) pre[nums[k]] * suf;
                } else {
                    suf++;
                }
            }
            for (int x = nums[j] + 1; x <= n; x++) pre[x]++;
        }
        return ans;
    }
}