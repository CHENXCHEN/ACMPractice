package leetcode.normal.j2163;

import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-difference-in-sums-after-removal-of-elements/description/">2163. 删除元素后和的最小差值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length, k = n / 3;
        // left[i] 表示从 [0...i] 为止，最小的 k 个数之和
        // right[i] 表示从 [i...n-1] 为止，最大的 k 个数之和
        long[] left = new long[n + 1], right = new long[n + 1];
        PriorityQueue<Long> pqMin = new PriorityQueue<>((x, y) -> Long.compare(x, y));
        PriorityQueue<Long> pqMax = new PriorityQueue<>((x, y) -> Long.compare(y, x));
        long cur = 0;
        for (int i = 0; i < k; i++) {
            pqMax.offer((long) nums[i]);
            cur += nums[i];
        }
        left[k - 1] = cur;
        for (int i = k; i < n - k; i++) {
            pqMax.offer((long) nums[i]);
            cur += nums[i] - pqMax.poll();
            left[i] = Math.min(left[i - 1], cur);
        }
        cur = 0;
        for (int i = n - 1, j = 0; j < k; i--, j++) {
            pqMin.offer((long) nums[i]);
            cur += nums[i];
        }
        right[n - k] = cur;
        long ans = left[n - k - 1] - right[n - k];
        for (int i = n - k - 1; i >= k; i--) {
            pqMin.offer((long) nums[i]);
            cur += nums[i] - pqMin.poll();
            right[i] = Math.max(right[i + 1], cur);
            ans = Math.min(ans, left[i - 1] - right[i]);
        }
        return ans;
    }
}