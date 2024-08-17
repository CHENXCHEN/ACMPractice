package leetcode.normal.j3097;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/shortest-subarray-with-or-at-least-k-ii/description/">3097. 或值至少为 K 的最短子数组 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int ans = Integer.MAX_VALUE, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= k) return 1;
            for (int j = i - 1; j >= 0 && (nums[j] | nums[i]) != nums[j]; j--) {
                // 修改 nums[j] 的值，或上 nums[i] 的值
                // 修改之后，则表示 nums[j] 被 nums[i] 访问过
                // 在 k > i 的元素进行比对时，如果 nums[j] | nums[k] == nums[j]，那么表示这个路径已经被走过，可以不走了
                // 这里其实是一种对过去已经搜寻过的状态的一种缓存，利用这种方式来跳过已经做过的判断
                nums[j] |= nums[i];
                if (nums[j] >= k) ans = Math.min(ans, i - j + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}