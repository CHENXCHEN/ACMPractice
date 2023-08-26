package leetcode.normal.j228;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/summary-ranges/">228. 汇总区间</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int left = 0;
        while (left < nums.length) {
            int right = left + 1;
            while (right < nums.length && nums[right] - nums[right - 1] == 1) right++;
            StringBuilder sb = new StringBuilder();
            sb.append(nums[left]);
            if (right - 1 != left) {
                sb.append("->").append(nums[right - 1]);
            }
            ans.add(sb.toString());
            left = right;
        }
        return ans;
    }
}