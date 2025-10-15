package leetcode.normal.j3350;

import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/adjacent-increasing-subarrays-detection-ii/description/">3350. 检测相邻递增子数组 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int i = 0, lastIncrCnt = 0, ans = 0;
        while (i < nums.size()) {
            int j = i + 1;
            while (j < nums.size() && nums.get(j) > nums.get(j - 1)) {
                ++j;
            }
            int curIncrCnt = j - i;
            ans = Math.max(ans, Math.min(lastIncrCnt, curIncrCnt));
            ans = Math.max(ans, curIncrCnt / 2);
            lastIncrCnt = curIncrCnt;
            i = j;
        }
        return ans;
    }
}