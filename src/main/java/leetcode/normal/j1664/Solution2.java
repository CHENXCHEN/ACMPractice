package leetcode.normal.j1664;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/ways-to-make-a-fair-array/">1664. 生成平衡数组的方案数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int waysToMakeFair(int[] nums) {
        int ans = 0;
        // cnt1 为 i 右边的元素，奇数下标的元素和以及偶数下标元素和
        // cnt2 为 i 左边的元素，奇数下标的元素和以及偶数下标元素和
        // 如果去除第 i 个元素，那 i 右边的元素奇偶下标元素和会掉过来
        int[] cnt1 = new int[2], cnt2 = new int[2];
        for (int i = 0; i < nums.length; i++) cnt1[i & 1] += nums[i];
        for (int i = 0; i < nums.length; i++) {
            cnt1[i & 1] -= nums[i];
            if (cnt1[0] + cnt2[1] == cnt1[1] + cnt2[0]) ++ans;
            cnt2[i & 1] += nums[i];
        }
        return ans;
    }
}