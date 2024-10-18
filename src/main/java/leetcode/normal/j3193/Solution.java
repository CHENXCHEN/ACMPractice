package leetcode.normal.j3193;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-the-number-of-inversions/description/">3193. 统计逆序对的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    Map<Integer, Integer> reqMap = new HashMap<>();
    long[][] dp;
    int MOD = 1000000007;

    public int numberOfPermutations(int n, int[][] requirements) {
        int maxCnt = 0;
        reqMap.put(0, 0);
        for (int[] req : requirements) {
            reqMap.put(req[0], req[1]);
            maxCnt = Math.max(maxCnt, req[1]);
        }
        if (reqMap.get(0) != 0) return 0;
        dp = new long[n][maxCnt + 1];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        return (int) dfs(n - 1, reqMap.get(n - 1));
    }

    long dfs(int end, int cnt) {
        if (cnt < 0) return 0;
        if (end == 0) return 1;
        if (dp[end][cnt] != -1) return dp[end][cnt];
        if (reqMap.containsKey(end - 1)) {
            int r = reqMap.get(end - 1);
            // 如果 end - 1 长度的逆序对存在限制为 r，那么当前 end 长度的逆序数为当前位置与前面的序号组成的逆序数 cnt - r
            // 且需要满足：0 <= cnt - r <= end
            if (r <= cnt && cnt <= end + r) {
                return dp[end][cnt] = dfs(end - 1, r);
            } else {
                return dp[end][cnt] = 0;
            }
        } else {
//            int sum = 0;
//            for (int i = 0; i <= Math.min(end, cnt); i++) {
//                sum = (sum + dfs(end - 1, cnt - i)) % MOD;
//            }
//            return dp[end][cnt] = sum;
            // dp[end][cnt] = sum(dp[end-1][cnt-i])，那么 dp[end][cnt-1] = sum(dp[end-1][cnt-i-1])
            if (cnt >= end) {
                // 因此 dp[end][cnt] = dp[end][cnt-1] - dp[end-1][cnt-end-1] + dp[end-1][cnt]
                return dp[end][cnt] = (dfs(end, cnt - 1) - dfs(end - 1, cnt - end - 1) + dfs(end - 1, cnt) + MOD) % MOD;
            } else {
                // 因此 dp[end][cnt] = dp[end][cnt] + dp[end-1][cnt]
                return dp[end][cnt] = (dfs(end, cnt - 1) + dfs(end - 1, cnt) + MOD) % MOD;
            }
        }
    }
}