package leetcode.normal.j3362;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/zero-array-transformation-iii/description/">3362. 零数组变换 III</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        int[] diff = new int[nums.length + 1];
        int sum = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            sum += diff[i];
            // 加入合法的后面可以选择的区间
            while (j < queries.length && queries[j][0] == i) {
                pq.add(queries[j][1]);
                j++;
            }
            // 贪心，每次选最长的区间
            while (sum + nums[i] > 0 && !pq.isEmpty() && pq.peek() >= i) {
                sum -= 1;
                diff[pq.poll() + 1] += 1;
            }
            if (sum + nums[i] > 0) return -1;
        }
        return pq.size();
    }
}