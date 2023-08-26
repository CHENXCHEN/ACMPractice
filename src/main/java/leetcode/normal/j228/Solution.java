package leetcode.normal.j228;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/summary-ranges/">228. 汇总区间</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (last == -1) {
                last = i;
            } else if (nums[i] - nums[last] != i - last) {
                if (i - 1 == last) {
                    ans.add(String.valueOf(nums[last]));
                } else {
                    ans.add(nums[last] + "->" + nums[i - 1]);
                }
                last = i;
            }
        }
        if (last != -1) {
            if (last == nums.length - 1) {
                ans.add(String.valueOf(nums[last]));
            } else {
                ans.add(nums[last] + "->" + nums[nums.length - 1]);
            }
        }
        return ans;
    }
}