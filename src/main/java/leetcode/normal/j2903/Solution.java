package leetcode.normal.j2903;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-indices-with-index-and-value-difference-i/description/">2903. 找出满足差值条件的下标 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        tMap.put(nums[0], 0);
        int n = nums.length, leftPos = 0;
        int[] ans = {-1, -1};
        for (int i = indexDifference; i < n; i++) {
            // x - num[i] >= valueDiff or num[i] - x >= valueDiff
            // => x >= valueDiff + num[i] or num[i] - valueDiff >= x
            Map.Entry<Integer, Integer> ceil = tMap.ceilingEntry(valueDifference + nums[i]);
            Map.Entry<Integer, Integer> floor = tMap.floorEntry(nums[i] - valueDifference);
            if (ceil != null) {
                ans[0] = ceil.getValue();
                ans[1] = i;
                break;
            } else if (floor != null) {
                ans[0] = floor.getValue();
                ans[1] = i;
                break;
            }
            if (leftPos + 1 < n) tMap.put(nums[++leftPos], leftPos);
        }
        return ans;
    }
}