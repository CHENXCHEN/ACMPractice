package leetcode.normal.j300;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/longest-increasing-subsequence/
 * 300. 最长递增子序列
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int nowNum = nums[i];
            Map.Entry<Integer, Integer> floorEntry = tMap.lowerEntry(nowNum);
            int nowCnt = 0;
            if (floorEntry == null) {
                nowCnt = 1;
            } else {
                nowCnt = floorEntry.getValue() + 1;
            }
            ans = Math.max(ans, nowCnt);
            Map.Entry<Integer, Integer> ceilEntry = tMap.ceilingEntry(nowNum);
            if (ceilEntry == null) {
                tMap.put(nowNum, nowCnt);
            } else if (ceilEntry.getValue() <= nowCnt) {
                tMap.remove(ceilEntry.getKey());
                tMap.put(nowNum, nowCnt);
            }
        }
        return ans;
    }
}