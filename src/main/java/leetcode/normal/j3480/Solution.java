package leetcode.normal.j3480;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximize-subarrays-after-removing-one-conflicting-pair/description/">3480. 删除一个冲突对后最大子数组数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        // bMin1[i] 表示左端点为 i 的最小右端点
        // bMin2[i] 表示左端点为 i 的次小右端点
        // 这两个数组的目的是为了辅助计算当某个冲突对删除之后，可以增加的组合数
        int[] bMin1 = new int[n + 1], bMin2 = new int[n + 1];
        Arrays.fill(bMin1, Integer.MAX_VALUE);
        Arrays.fill(bMin2, Integer.MAX_VALUE);
        for (int[] pair : conflictingPairs) {
            int a = Math.min(pair[0], pair[1]), b = Math.max(pair[0], pair[1]);
            if (bMin1[a] > b) {
                bMin2[a] = bMin1[a];
                bMin1[a] = b;
            } else if (bMin2[a] > b) {
                bMin2[a] = b;
            }
        }
        // res 先计算不做删除情况下的组合数
        long res = 0;
        // lastIdx 上一个有限制的左端点，lastMin 表示上一个左端点的最小右端点
        int lastIdx = n, lastMin = Integer.MAX_VALUE;
        // delCount[i] 表示，删除左端点 i 时，可以增加的组合数
        long[] delCount = new long[n + 1];
        // 从右往左枚举左端点
        for (int i = n; i >= 1; i--) {
            if (bMin1[lastIdx] > bMin1[i]) {
                lastMin = Math.min(lastMin, bMin1[lastIdx]);
                lastIdx = i;
            } else {
                lastMin = Math.min(lastMin, bMin1[i]);
            }
            res += Math.min(bMin1[lastIdx], n + 1) - i;
            // 左端点 lastIdx 相关的冲突对，删除后可以增加的组合数
            // 次小 - 最小 的长度
            delCount[lastIdx] += Math.min(Math.min(lastMin, bMin2[lastIdx]), n + 1) - Math.min(bMin1[lastIdx], n + 1);
        }
        long ans = 0;
        for (long v : delCount) {
            ans = Math.max(ans, res + v);
        }
        return ans;
    }
}