package leetcode.normal.j163;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/missing-ranges/">163. 缺失的区间</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        ArrayList<String> ans = new ArrayList<>();
        int last = lower - 1;
        for (int i = 0; i <= nums.length; i++) {
            StringBuilder sb = new StringBuilder();
            int now = i == nums.length ? upper + 1 : nums[i];
            if (now - last == 2) {
                sb.append(now - 1);
            } else if (now - last > 2) {
                sb.append(last + 1).append("->").append(now - 1);
            }
            if (sb.length() > 0) ans.add(sb.toString());
            last = now;
        }
        return ans;
    }
}