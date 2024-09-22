package leetcode.normal.j163;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/missing-ranges/">163. 缺失的区间</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution3 {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        int last = lower - 1;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            // 获取当前的数字
            int now = i == nums.length ? upper + 1 : nums[i];
            if (now - last >= 2) {
                // 如果当前元素和之前的不连续
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(last + 1);
                tmp.add(now - 1);
                ans.add(tmp);
            }
            last = now;
        }
        return ans;
    }
}
