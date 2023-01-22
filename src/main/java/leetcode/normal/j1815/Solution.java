package leetcode.normal.j1815;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-number-of-groups-getting-fresh-donuts/solutions/">1815. 得到新鲜甜甜圈的最多组数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int K_WIDTH = 5;
    int K_WIDTH_MASK = (1 << K_WIDTH) - 1;


    public int maxHappyGroups(int batchSize, int[] groups) {
        int[] cnt = new int[batchSize];
        // 我们最终目的是从 groups 里取一些数组成一个集合，集合的和是 batchSize 的倍数，最多能组多少集合
        // 其实只需要关注对 batchSize 取模的结果即可，我们计算对 batchSize 取模的计数，然后在 1...batchSize-1 过程中挑选集合即可
        for (int group : groups) cnt[group % batchSize]++;
        long start = 0;
        // 题目给定的数据范围一共只有 30，不超过 5 位二进制，而 batchSize 不超过 9 ，
        // 那么 5 * 9 = 45，可以用 long 来压缩计数
        for (int i = batchSize - 1; i > 0; i--) start = (start << K_WIDTH) | cnt[i];
        Map<Long, Integer> memo = new HashMap<>();
        // 我们每次可以只考虑最后一个数是不是快乐数，然后记忆化搜索
        return dfs(memo, batchSize, start) + cnt[0];
    }

    int dfs(Map<Long, Integer> memo, int batchSize, long mask) {
        if (mask == 0) return 0;
        if (!memo.containsKey(mask)) {
            int tot = 0;
            for (int i = 1; i < batchSize; i++) {
                long amount = (mask >> ((i - 1) * K_WIDTH)) & K_WIDTH_MASK;
                tot += i * amount;
            }
            int best = 0;
            for (int i = 1; i < batchSize; i++) {
                long amount = (mask >> ((i - 1) * K_WIDTH)) & K_WIDTH_MASK;
                if (amount > 0) {
                    int ret = dfs(memo, batchSize, mask - (1L << ((i - 1) * K_WIDTH)));
                    if ((tot - i) % batchSize == 0) {
                        ++ret;
                    }
                    best = Math.max(best, ret);
                }
            }
            memo.put(mask, best);
            return best;
        }
        return memo.get(mask);
    }
}