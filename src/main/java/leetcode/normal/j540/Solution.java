package leetcode.normal.j540;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/single-element-in-a-sorted-array/description/">540. 有序数组中的单一元素</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}