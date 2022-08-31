package leetcode.normal.j2474;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/">剑指 Offer 21. 调整数组顺序使奇数位于偶数前面</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] exchange(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            while (l < r && (nums[l] & 1) == 1) l++;
            while (l < r && (nums[r] & 1) == 0) r--;
            if (l < r) {
                int tmp = nums[r];
                nums[r] = nums[l];
                nums[l] = tmp;
            }
        }
        return nums;
    }
}