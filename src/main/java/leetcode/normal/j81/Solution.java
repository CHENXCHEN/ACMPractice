package leetcode.normal.j81;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/description/">81. 搜索旋转排序数组 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int vMid = nums[mid], vLeft = nums[left], vRight = nums[right];
            if (vMid == target) return true;
            else if (vLeft < vMid) {
                // 如果 [left,mid] 区间满足升序
                // 1. 若 target 的值范围位于区间 [left,mid) 之内，令 right = mid - 1
                // 2. 若 target 的值范围不在区间 [left,mid) 之内，令 left = mid + 1
                if (vLeft <= target && target < vMid) right = mid - 1;
                else left = mid + 1;
            } else if (vLeft > vMid) {
                // 如果 (mid,right] 区间不满足升序，那么 (mid,right] 一定满足升序
                // 1. 若 target 的值位于 (mid,right] 之内，令 left = mid + 1
                // 2. 若 target 的值不在 (mid,right] 之类，令 right = mid - 1
                if (vMid < target && target <= vRight) left = mid + 1;
                else right = mid - 1;
            } else {
                // 如果 vLeft = vMid，那么随机缩减左区间
                left++;
            }
        }
        return false;
    }
}