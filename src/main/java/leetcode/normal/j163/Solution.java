package leetcode.normal.j163;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/missing-ranges/">163. 缺失的区间</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        ArrayList<String> ans = new ArrayList<>();
        int start = 0;
        while (start < nums.length && nums[start] < lower) start++;
        int mark = lower;
        while (start < nums.length && nums[start] <= upper) {
            while (start < nums.length && nums[start] == mark) {
                start++;
                mark++;
            }
            if (mark <= upper) {
                if (start < nums.length) {
                    if (nums[start] - mark > 1) {
                        ans.add(String.format("%d->%d", mark, nums[start] - 1));
                    } else {
                        ans.add("" + mark);
                    }
                    mark = nums[start] + 1;
                    start++;
                } else {
                    if (upper - mark > 0) {
                        ans.add(String.format("%d->%d", mark, upper));
                    } else {
                        ans.add("" + mark);
                    }
                    mark = upper + 1;
                }
            }
        }
        if (mark <= upper) {
            if (mark == upper) ans.add("" + mark);
            else ans.add(String.format("%d->%d", mark, upper));
        }
        return ans;
    }
}