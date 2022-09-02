package leetcode.normal.j646;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-length-of-pair-chain/">646. 最长数对链</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (int[] p1, int[] p2) -> {
            if (p1[0] != p2[0]) return p1[0] - p2[0];
            return p1[1] - p2[1];
        });
        int len = 1;
        int[] dp = new int[pairs.length];
        dp[0] = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > dp[len - 1]) {
                dp[len++] = pairs[i][1];
            } else {
                int idx = findIdx(dp, len, pairs[i][0]);
                if (pairs[i][1] < dp[idx]) dp[idx] = pairs[i][1];
            }
        }
        return len;
    }

    int findIdx(int[] dp, int len, int vv) {
        int left = 0, right = len - 1, ans = 0;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (dp[mid] >= vv) {
                ans = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return ans;
    }
}