package leetcode.normal.j795;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-subarrays-with-bounded-maximum/">795. 区间子数组个数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        // last1 => 最后一个符合 [left, right] 的坐标
        // last2 => 最后一个 > right 的坐标
        // 枚举每一个 i 作为右端点，总是有 (last2, last1] 个左端点，如果 last1 != -1
        int last1 = -1, last2 = -1, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) {
                last2 = i;
                last1 = -1;
            } else if (nums[i] >= left) {
                last1 = i;
            }
            if (last1 != -1) ans += last1 - last2;
        }
        return ans;
    }
}