package leetcode.normal.j922;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/sort-array-by-parity-ii/description/">922. 按奇偶排序数组 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int oddPos = 1, evenPos = 0, n = nums.length;
        while (oddPos < n && evenPos < n) {
            while (evenPos < n && nums[evenPos] % 2 == 0) evenPos += 2;
            while (oddPos < n && nums[oddPos] % 2 == 1) oddPos += 2;
            if (evenPos < n && oddPos < n) {
                int temp = nums[oddPos];
                nums[oddPos] = nums[evenPos];
                nums[evenPos] = temp;
            }
        }
        return nums;
    }
}