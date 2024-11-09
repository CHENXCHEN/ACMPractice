package leetcode.normal.j540;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/single-element-in-a-sorted-array/description/">540. 有序数组中的单一元素</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    int[] nums;

    public int singleNonDuplicate(int[] nums) {
        this.nums = nums;
        int n = nums.length, left = 0, right = n - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (!check(mid)) {
                ans = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return nums[ans];
    }

    boolean check(int x) {
        if (x % 2 == 0) {
            return x + 1 < nums.length && nums[x] == nums[x + 1];
        } else {
            return x - 1 >= 0 && nums[x] == nums[x - 1];
        }
    }
}