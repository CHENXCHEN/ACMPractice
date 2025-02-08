package leetcode.normal.j80;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/">80. 删除有序数组中的重复项 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int len = 0, i = 0;
        int n = nums.length;
        while (i < n) {
            int num = nums[i], cnt = 0;
            while (i < n && num == nums[i] && cnt < 2) {
                nums[len++] = num;
                i++;
                ++cnt;
            }
            while (i < n && num == nums[i]) ++i;
        }
        return len;
    }
}