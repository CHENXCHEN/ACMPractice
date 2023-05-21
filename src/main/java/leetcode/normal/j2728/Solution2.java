package leetcode.normal.j2728;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/o8SXZn/">LCP 33. 蓄水</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {

    public int storeWater(int[] bucket, int[] vat) {
        // 只需要考虑先增加桶的大小，再统一蓄水，这样是最大的
        // 可以考虑如果最终结果为蓄水 k 次，那么每个桶的大小是多少，我们只需要枚举蓄水次数，取最小操作即可
        int ans = Integer.MAX_VALUE;
        int vatMax = Arrays.stream(vat).max().getAsInt();
        if (vatMax == 0) return 0;
        for (int k = 1; k <= vatMax && k < ans; k++) {
            int times = 0;
            for (int i = 0; i < bucket.length; i++) {
                // 如果需要 k 次蓄水，那么当前 bucket 的大小应该为多少
                times += Math.max(0, (vat[i] + k - 1) / k - bucket[i]);
            }
            ans = Math.min(ans, times + k);
        }
        return ans;
    }
}