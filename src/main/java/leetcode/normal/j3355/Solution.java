package leetcode.normal.j3355;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/zero-array-transformation-i/description/">3355. 零数组变换 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] marked = new int[n + 1];
        for (int[] query : queries) {
            marked[query[0]]--;
            marked[query[1] + 1]++;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += marked[i];
            nums[i] += sum;
            if (nums[i] > 0) return false;
        }
        return true;
    }
}