package leetcode.normal.j905;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/sort-array-by-parity/
 * 905. 按奇偶排序数组
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int leftPos = 0;
        for (int i = 0; i < nums.length; i++) {
            while (leftPos < nums.length && nums[leftPos] % 2 == 0) leftPos++;
            if (nums[i] % 2 == 0 && leftPos < i) {
                int tmp = nums[i];
                nums[i] = nums[leftPos];
                nums[leftPos] = tmp;
            }
        }
        return nums;
    }
}