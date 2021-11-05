package leetcode.normal.j1218;

import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference/
 * 1218. 最长定差子序列
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        int ans = 0;
        for (int item : arr) {
            int m = tMap.getOrDefault(item - difference, 0) + 1;
            ans = Math.max(ans, m);
            tMap.put(item, m);
        }
        return ans;
    }
}