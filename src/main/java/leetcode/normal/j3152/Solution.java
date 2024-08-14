package leetcode.normal.j3152;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/special-array-ii/description/">3152. 特殊数组 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        preSum[1] = 1;
        int last = nums[0] & 1;
        for (int i = 1; i < n; i++) {
            int cur = nums[i] & 1;
            if (cur == last) {
                preSum[i + 1] = preSum[i] + 1;
            } else {
                preSum[i + 1] = preSum[i];
            }
            last = cur;
        }
//        System.out.println(Arrays.toString(preSum));
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            ans[i] = preSum[query[1] + 1] == preSum[query[0] + 1];
        }
        return ans;
    }
}