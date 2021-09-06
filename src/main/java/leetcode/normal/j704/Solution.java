package leetcode.normal.j704;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/binary-search/
 * 704. 二分查找
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l+r) >> 1;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else return mid;
        }
        return -1;
    }
}