package leetcode.normal.j2178;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-split-of-positive-even-integers/">2178. 拆分成最多数目的正偶数之和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> ans = new ArrayList<>();
        if (finalSum % 2 != 0) return ans;
        for (int i = 2; i <= finalSum; i += 2) {
            ans.add((long) i);
            finalSum -= i;
        }
        ans.set(ans.size() - 1, ans.get(ans.size() - 1) + finalSum);
        return ans;
    }
}