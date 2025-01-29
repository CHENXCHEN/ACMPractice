package leetcode.normal.j167;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/">167. 两数之和 II - 输入有序数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        for (int i = 1; i < numbers.length; i++) {
            int prePos = binarySearch(numbers, 0, i - 1, target - numbers[i]);
            if (prePos != -1) {
                ans[0] = prePos + 1;
                ans[1] = i + 1;
                break;
            }
        }
        return ans;
    }

    int binarySearch(int[] numbers, int left, int right, int target) {
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (numbers[mid] == target) return mid;
            else if (numbers[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return ans;
    }
}