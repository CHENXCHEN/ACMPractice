package leetcode.normal.j2561;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/rearranging-fruits/description/">2561. 重排水果</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        // 1. 数组顺序不重要，且任意成本出现次数为偶数才有解
        // 2. 调整方式有几种方式，假设两个数组中的最小成本为 k
        //      调整一次的最小成本为：k
        //      调整两次的最小成本为：[k, 2k]，如果要调整的两个成本之和大于 2k，那不如两次都用最小成本调整
        // 3. 把需要调整的所有成本都列出来，排序之后，首尾选择
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        int m = Integer.MAX_VALUE;
        for (int i = 0; i < basket1.length; i++) {
            freq.compute(basket1[i], (k, v) -> v == null ? 1 : v + 1);
            freq.compute(basket2[i], (k, v) -> v == null ? -1 : v - 1);
            m = Math.min(m, Math.min(basket1[i], basket2[i]));
        }
        List<Integer> merge = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int count = entry.getValue();
            if (count % 2 != 0) return -1;
            // 这里一共多出了 count 个，我们需要分出 count/2 到另一边，这里记录需要交换的成本
            for (int i = 0; i < Math.abs(count) / 2; i++) {
                merge.add(entry.getKey());
            }
        }
        Collections.sort(merge);
        long ans = 0;
        // 每次只需要首位匹配操作，因此只需要看最小的 merge.size() / 2 即可
        for (int i = 0; i < merge.size() / 2; i++) {
            ans += Math.min(2 * m, merge.get(i));
        }
        return ans;
    }
}