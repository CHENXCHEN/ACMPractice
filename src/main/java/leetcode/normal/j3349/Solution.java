package leetcode.normal.j3349;

import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/adjacent-increasing-subarrays-detection-i/description/">3349. 检测相邻递增子数组 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int i = 0, lastIncrCnt = 0;
        while (i < nums.size()) {
            int j = i + 1;
            while (j < nums.size() && nums.get(j) > nums.get(j - 1)) ++j;
            int curIncrCnt = j - i;
            if ((curIncrCnt >= k && lastIncrCnt >= k) || curIncrCnt >= 2 * k) {
                return true;
            }
            lastIncrCnt = curIncrCnt;
            i = j;
        }
        return false;
    }
}