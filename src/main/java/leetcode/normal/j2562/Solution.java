package leetcode.normal.j2562;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-array-concatenation-value/description/">2562. 找出数组的串联值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long sum = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            sum += Long.parseLong(String.valueOf(nums[left]) + nums[right]);
            left++;
            right--;
        }
        if (left == right) sum += nums[left];
        return sum;
    }
}