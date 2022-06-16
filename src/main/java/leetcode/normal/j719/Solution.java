package leetcode.normal.j719;

import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/find-k-th-smallest-pair-distance/
 * 719. 找出第 K 小的数对距离
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int[] has = new int[1000000 + 1], preSum = new int[1000000 + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int cur = Math.abs(nums[i] - nums[j]);
                has[cur]++;
            }
        }
        preSum[0] = has[0];
        for (int i = 1; i < preSum.length; i++) preSum[i] = preSum[i - 1] + has[i];
        return binarySearch(preSum, k);
    }

    int binarySearch(int[] preSum, int k) {
        int left = 0, right = preSum.length - 1, ans = 0;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (preSum[mid] < k) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        while (ans < preSum.length && preSum[ans] < k) ans++;
        while (ans > 0 && preSum[ans] == preSum[ans - 1]) ans--;
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {62, 100, 4};
        System.out.println(solution.smallestDistancePair(nums, 2));
    }
}
