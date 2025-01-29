package leetcode.normal.j167;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/">167. 两数之和 II - 输入有序数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution3 {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int ss = numbers[left] + numbers[right];
            if (ss > target) {
                // 如果相加大于 target，那么意味着 [left,right-1] 这些数和 right 相加都会大于 target，我们缩减 right，缩减检索空间
                right--;
            } else if (ss < target) {
                // 如果相加小于 target，那么意味着 [left+1,right] 这些数和 left 相加都会小于 target，我们增加 left，缩减检索空间
                left++;
            } else {
                ans[0] = left + 1;
                ans[1] = right + 1;
                break;
            }
        }
        return ans;
    }
}