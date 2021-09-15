package leetcode.normal.j162;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/find-peak-element/
 * 162. 寻找峰值
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    int compare(int[] nums, int posL, int posR) {
        if (posL == -1) return -1;
        else if (posR == nums.length) return 1;
        else return nums[posL] - nums[posR];
    }

    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1, ans = -1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (compare(nums, m - 1, m) < 0 && compare(nums, m, m + 1) > 0) {
                ans = m;
                break;
            }
            if (compare(nums, m, m + 1) < 0) {
                l = m + 1;
            } else r = m - 1;
        }
        return ans;
    }
}
