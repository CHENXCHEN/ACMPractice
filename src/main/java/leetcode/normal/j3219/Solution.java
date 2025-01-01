package leetcode.normal.j3219;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-cost-for-cutting-cake-ii/description/">3219. 切蛋糕的最小总开销 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        // 优先切成本大的
        // 如果之前水平已经切过了 hCnt 次，那现在垂直切需要 hCnt + 1 次
        // 如果之前垂直已经切过了 vCnt 次，那现在水平切需要 vCnt + 1 次
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        int hIdx = horizontalCut.length - 1, vIdx = verticalCut.length - 1;
        int hCnt = 1, vCnt = 1;
        long ans = 0;
        while (hIdx >= 0 || vIdx >= 0) {
            if (vIdx < 0 || (hIdx >= 0 && horizontalCut[hIdx] > verticalCut[vIdx])) {
                ans += (long) horizontalCut[hIdx--] * hCnt;
                vCnt++;
            } else {
                ans += (long) verticalCut[vIdx--] * vCnt;
                hCnt++;
            }
        }
        return ans;
    }
}