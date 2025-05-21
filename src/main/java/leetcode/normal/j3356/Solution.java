package leetcode.normal.j3356;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/zero-array-transformation-ii/description/">3356. 零数组变换 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] nums;
    int[][] queries;

    public int minZeroArray(int[] nums, int[][] queries) {
        this.nums = nums;
        this.queries = queries;
        if (check(-1)) return 0;
        int l = 0, r = queries.length - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (check(mid)) {
                ans = mid + 1;
                r = mid - 1;
            } else l = mid + 1;
        }
        return ans;
    }

    boolean check(int k) {
        int[] marked = new int[nums.length + 1];
        for (int i = 0; i <= k; i++) {
            int left = queries[i][0], right = queries[i][1], val = queries[i][2];
            marked[left] -= val;
            marked[right + 1] += val;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += marked[i];
            if (nums[i] + sum > 0) return false;
        }
        return true;
    }
}