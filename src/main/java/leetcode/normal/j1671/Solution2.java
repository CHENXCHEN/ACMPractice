package leetcode.normal.j1671;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-number-of-removals-to-make-mountain-array/description/">1671. 得到山形数组的最少删除次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n], rightSum = new int[n];
        int[] res = new int[n + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        for (int i = 0; i < n; i++) {
            leftSum[i] = addLongest(res, nums[i]);
        }
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        for (int i = n - 1; i >= 0; i--) {
            rightSum[i] = addLongest(res, nums[i]);
        }
//        System.out.println(Arrays.toString(leftSum));
//        System.out.println(Arrays.toString(rightSum));
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int left = i + 1 - leftSum[i], right = n - i - rightSum[i];
            if (leftSum[i] > 1 && rightSum[i] > 1) ans = Math.min(ans, left + right);
        }
        return ans;
    }

    int addLongest(int[] res, int vv) {
        int left = res[0] == 0 ? 1 : Arrays.binarySearch(res, 1, res[0] + 1, vv);
        left = left < 0 ? -left - 1 : left;
        res[0] = Math.max(res[0], left);
        res[left] = Math.min(res[left], vv);
        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 20, 50};
        System.out.println(Arrays.binarySearch(arr, 0, arr.length, 19));
        System.out.println(Arrays.binarySearch(arr, 0, arr.length, 20));
    }
}