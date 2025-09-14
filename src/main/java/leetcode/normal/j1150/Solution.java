package leetcode.normal.j1150;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/check-if-a-number-is-majority-element-in-a-sorted-array/description/">1150. 检查一个数是否在数组中占绝大多数</a>
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int cnt = 0;
        for (int num : nums) {
            if (num == target) {
                cnt++;
            }
        }
        return cnt > nums.length / 2;
    }
}